package cn.service.impl;

import cn.dao.PshopingDao;
import cn.pojo.Pshoping;
import cn.service.HuntService;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HuntServiceImpl implements HuntService {

    public List<Pshoping> hunt(String pool) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PshopingDao ps = sqlSession.getMapper(PshopingDao.class);
        List<Pshoping> li = new ArrayList<Pshoping>();
        List<Pshoping> shoping = ps.allPshopings(new Pshoping());
        Pattern pattern = Pattern.compile(pool);
        for (int i = 0; i < shoping.size(); i++) {
            Matcher matcher = pattern.matcher(shoping.get(i).getPcommodity());
            if (matcher.find()) {
                li.add(shoping.get(i));
            }
        }
        return li;
    }
}
