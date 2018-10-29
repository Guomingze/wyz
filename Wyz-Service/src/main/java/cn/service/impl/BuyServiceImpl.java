package cn.service.impl;

import cn.dao.OrderDao;
import cn.dao.PshopingDao;
import cn.pojo.Order;
import cn.pojo.Orderll;
import cn.pojo.Pshoping;
import cn.pojo.Users;
import cn.service.BuyService;
import cn.service.LoginService;
import cn.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import java.util.List;

public class BuyServiceImpl implements BuyService {


    @Override
    public int buy(String code, int pid, int num) {
        int i = 0;
        Pshoping pshoping=new Pshoping();
        pshoping.setPid((long) pid);
        Order order=new Order();
        LoginService log=new LoginServiceImpl();
        Users user = log.getUser(code);
        if (user != null) {
            Pshoping pshoping1 = MyBatisUtil.getSqlSession().getMapper(PshopingDao.class).selectDimShoping(pshoping).get(0);
            order.setOname((int) user.getUid());
            order.setOcommodity(pid);
            order.setOnumber(num);
            order.setOmoney((int) (pshoping1.getPmoney()*num));
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            i = sqlSession.getMapper(OrderDao.class).addOrder(order);
            sqlSession.commit();
        }
        return i;
    }

    @Override
    public List<Order> alldin(String code, int state) {
        List<Order> orderList=null;
        LoginService log=new LoginServiceImpl();
        Users user = log.getUser(code);
        Order order=new Order();
        if (user != null){
            order.setOname((int) user.getUid());
            order.setOstate(state);
            orderList = MyBatisUtil.getSqlSession().getMapper(OrderDao.class).selectOrder(order);
        }
        return orderList;
    }

    @Override
    public int amendOrder(String code, int pid,int state) {
        int i=0;
        Pshoping pshoping=new Pshoping();
        pshoping.setPid((long) pid);
        LoginService log=new LoginServiceImpl();
        Users user = log.getUser(code);
        long pid1 = MyBatisUtil.getSqlSession().getMapper(PshopingDao.class).selectDimShoping(pshoping).get(0).getPid();
        if(user != null && pid1 !=0){
            Order order=new Order();
            order.setOname((int) user.getUid());
            order.setOcommodity((int) pid1);
            Order order1 = MyBatisUtil.getSqlSession().getMapper(OrderDao.class).selectOrder(order).get(0);
            if (order1 != null){
                order.setOstate(state);
                 i = MyBatisUtil.getSqlSession().getMapper(OrderDao.class).amendOrder(order);
            }
        }
        return i;
    }

    @Override
    public List<Orderll> seletAll(String code, int state) {
        List<Orderll> orderlls=null;
        LoginService log=new LoginServiceImpl();
        Users user = log.getUser(code);
        Order order=new Order();
        if (user != null){
            order.setOname((int) user.getUid());
            order.setOstate(state);
            orderlls = MyBatisUtil.getSqlSession().getMapper(OrderDao.class).selectAll(order);
        }
        return orderlls;
    }
}
