package cn.service;

import cn.pojo.Order;
import cn.pojo.Orderll;
import cn.pojo.Pshoping;

import java.util.List;

public interface BuyService {
    /**
     * 添加一条订单
     * @param
     * @return  影响行数
     */
    int buy(String code,int pid,int num);

    /**
     * 用户全部订单
     * @param
     * @return 该用户的全部订单集合
     */
    List<Order> alldin(String code,int state);

    /**
     * 修改订单各种状态
     * @param
     * @return 受影响行数
     */
    int amendOrder(String code,int pid,int state);

    /**
     * 获取待**集合
     * @param code
     * @param state
     * @return 返回待**集合
     */
     List<Orderll> seletAll(String code, int state);

}
