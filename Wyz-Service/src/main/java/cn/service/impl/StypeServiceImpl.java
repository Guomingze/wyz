package cn.service.impl;

import cn.dao.PshopingDao;
import cn.dao.TypeDao;
import cn.pojo.Pshoping;
import cn.pojo.Type;
import cn.service.StypeService;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class StypeServiceImpl implements StypeService {
    @Override
    public List<Pshoping> getAllType(Type type) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PshopingDao fd = sqlSession.getMapper(PshopingDao.class);
        Pshoping pshoping = new Pshoping();
        pshoping.setPtype(new Long(type.getTid()));
        return fd.selectDimShoping(pshoping);
    }

    @Override
    public List<Type> getAlltyp(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        TypeDao fd = sqlSession.getMapper(TypeDao.class);
        return fd.getAllType(new Type());
    }
}
