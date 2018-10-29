package cn.dao;

import cn.pojo.Order;
import cn.pojo.Orderll;

import java.util.List;

public interface OrderDao {
    /**
     * 添加订单
     * @param order 订单对象
     * @return 影响行数
     */
    int addOrder(Order order);



    /**
     * 修改订单各种内容
     * @param order 订单对象
     * @return 影响行数
     */
    int amendOrder(Order order);

    /**
     * 订单集合
     * @param order 订单对象
     * @return 该用户名下所有未删除订单
     */
    List<Order> selectOrder(Order order);

    /**
     * 待**订单集合
     * @param order 订单对象
     * @return 待**订单集合
     */
    List<Orderll> selectAll(Order order);
}
