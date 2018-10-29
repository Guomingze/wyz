package cn.service.impl;

import cn.dao.PshopingDao;
import cn.dao.TrolleyDao;
import cn.pojo.Pshoping;
import cn.pojo.Trolley;
import cn.service.TrolleyService;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TrolleyServiceImpl implements TrolleyService {
    SqlSession sqlSession = MyBatisUtil.getSqlSession();

    @Override
    public List<Trolley> shopping(int tuid) {
        Trolley tr = new Trolley();
        tr.setTuid(tuid);
        List<Trolley> ls = sqlSession.getMapper(TrolleyDao.class).shopping(tr);
        return ls;
    }

    @Override
    public int addshopping(Trolley tr) {
        int count;
        Trolley trolley = sqlSession.getMapper(TrolleyDao.class).seps(tr);
        Pshoping ps = new Pshoping();
        ps.setPid(tr.getTpid());
        List<Pshoping> ls = sqlSession.getMapper(PshopingDao.class).allPshopings(ps);
        if (trolley != null) {
            if (trolley.getTstate() > 0) {
                tr.setTmoney(trolley.getTmoney() + (tr.getTnumber() * ls.get(0).getPmoney()));
                tr.setTnumber(trolley.getTnumber() + tr.getTnumber());
                count = sqlSession.getMapper(TrolleyDao.class).information(tr);
            } else {
                tr.setTnumber(tr.getTnumber());
                tr.setTmoney(tr.getTnumber() * ls.get(0).getPmoney());
                count = sqlSession.getMapper(TrolleyDao.class).information(tr);
            }
        } else {
            tr.setTmoney(ls.get(0).getPmoney());
            count = sqlSession.getMapper(TrolleyDao.class).Addshopping(tr);
        }
        sqlSession.commit();

        return count;
    }

    @Override
    public int deleteshopping(long tid) {
        int count;
        Trolley tr = new Trolley();
        tr.setTid(tid);
        count = sqlSession.getMapper(TrolleyDao.class).deleteshopping(tr);
        sqlSession.commit();
        return count;
    }
}
