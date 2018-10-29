package cn.service.impl;

import cn.dao.FavoriteDao;
import cn.dao.UsersDao;
import cn.pojo.Pshoping;
import cn.pojo.Users;
import cn.service.FavoriteService;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

public class FavoriteServiceImpl implements FavoriteService {
    @Override
    public boolean collect(long shopingid, Users us) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        FavoriteDao fd = sqlSession.getMapper(FavoriteDao.class);
        UsersDao ud = sqlSession.getMapper(UsersDao.class);
        Pshoping pshoping = new Pshoping();
        pshoping.setPid(shopingid);
        boolean a = false;
        if(fd.getShopingFavorite(pshoping) == null && fd.getUserFavorite(us) == null){
            a = true;
        }
        return a;
    }
}
