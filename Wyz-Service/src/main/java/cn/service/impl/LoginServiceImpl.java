package cn.service.impl;

import cn.dao.UsersDao;
import cn.pojo.Users;
import cn.service.LoginService;
import cn.util.MyBatisUtil;
import cn.util.Openid;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class LoginServiceImpl implements LoginService {
    @Override
    public boolean userIsExist(String code) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
        Users u = new Users();
        boolean flag = false;
        String openid = getOpenid(code);
        u.setUpassword(openid);
        if (usersDao.isExist(u) != null) {
            flag = true;
        }
        return flag;
    }

    @Override
    public String getOpenid(String code) {
        SSLSocketFactory.getSocketFactory().setHostnameVerifier(new AllowAllHostnameVerifier());
        HttpClient hc = new DefaultHttpClient();
        //小程序登录凭证检验 请求地址
        HttpGet hg = new HttpGet("https://api.weixin.qq.com/sns/jscode2session?appid=wxce1b29b2285f207a&secret=886ba38dbfb1b9fbe596d8d3b9352b5d&js_code=" + code + "&grant_type=authorization_code");
        HttpResponse resp = null;
        String openid = "";
        try {
            resp = hc.execute(hg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (resp.getStatusLine().getStatusCode() == 200) {
            HttpEntity resEntity = resp.getEntity();
            try {
                //请求得到的响应内容 用户唯一标识
                openid = EntityUtils.toString(resEntity, "utf-8");
                Openid openid1 = JSON.parseObject(openid, Openid.class);
                openid = openid1.getOpenid();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("请求失败");
        }
        return openid;
    }

    @Override
    public boolean addUser(String openid) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
        boolean flag = false;
        Users users = new Users();
        users.setUpassword(openid);
        int count = usersDao.addUser(users);
        if(count > 0){
            flag = true;
            sqlSession.commit();
        }
        return flag;
    }

    @Override
    public Users getUser(String code) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
        String openid = getOpenid(code);
        Users users = new Users();
        users.setUpassword(openid);
        users = usersDao.isExist(users);
        if(users == null){
            addUser(openid);
        }
        return users;
    }

    @Override
    public boolean addUserInfo(Users users){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        UsersDao usersDao = sqlSession.getMapper(UsersDao.class);
        boolean flag = false;
        int count = usersDao.amendUser(users);
        System.out.println(users.getUname());
        if(count > 0){
            flag = true;
            sqlSession.commit();
        }
        return flag;
    }
}
