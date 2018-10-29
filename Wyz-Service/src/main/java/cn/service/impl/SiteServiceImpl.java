package cn.service.impl;

import cn.dao.SiteDao;
import cn.dao.UsersDao;
import cn.pojo.Site;
import cn.pojo.Users;
import cn.service.LoginService;
import cn.service.SiteService;
import cn.util.LianZha;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class SiteServiceImpl implements SiteService {
    @Override
    public List<LianZha> address(int suid) {
        List<LianZha> li = new ArrayList<LianZha>();
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SiteDao siteDao = sqlSession.getMapper(SiteDao.class);
        Site st = new Site();
        UsersDao ud = sqlSession.getMapper(UsersDao.class);
        Users users = new Users();
        users.setUid(suid);
        Users us = ud.isExist(users);
        st.setSuid(suid);
        List<Site> ls = siteDao.address(st);
        for (Site i : ls) {
            if(i != null) {
                LianZha lz = new LianZha();
                lz.setSid(i.getSid());
                lz.setSuid(i.getSuid());
                lz.setUname(us.getUname());
                lz.setSaddress(i.getSaddress());
                lz.setSphone(i.getSphone());
                li.add(lz);
            }
        }
        return li;
    }

    @Override
    public int addaddress(Site st) {
        int count = 0;
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SiteDao siteDao = sqlSession.getMapper(SiteDao.class);
        count = siteDao.addaddress(st);
        sqlSession.commit();
        return count;
    }

    @Override
    public boolean amendaddress(String phone,String saddress, int sid) {
        boolean a = false;
        Site st = new Site();
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        SiteDao siteDao = sqlSession.getMapper(SiteDao.class);
        st.setSaddress(saddress);
        st.setSid(sid);
        st.setSphone(phone);
        if (siteDao.amendaddress(st) > 0){
            a = true;
            sqlSession.commit();
        }
        return a;
    }

    @Override
    public String deleteaddress(int sid,String code) {
        boolean flag = false;
        boolean a = false;
        LoginService loginService = new LoginServiceImpl();
        Users users = loginService.getUser(code);
        Long uid = null;
        if(users == null){
            return "该用户查询失败";
        }else{
            uid = users.getUid();
        }
        List<LianZha> lianZhas = address(uid.intValue());
        for(LianZha lianZha : lianZhas){
            if(lianZha.getSid() == sid) {
                flag = true;
                break;
            }
        }
        if(flag) {
            Site st = new Site();
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            SiteDao siteDao = sqlSession.getMapper(SiteDao.class);
            st.setSid(sid);
            if (siteDao.deleteaddress(st) > 0) {
                a = true;
                sqlSession.commit();
            }
        }else{
            return "操作失败，用户与地址不符";
        }
        if(a){
            return "删除成功";
        }else{
            return "删除失败";
        }
    }
}
