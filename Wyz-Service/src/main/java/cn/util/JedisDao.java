package cn.util;

import cn.pojo.Order;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

public class JedisDao {
    Jedis jedis = new Jedis();

    public boolean addOrder(Order order){
        String OrderJson = JSON.toJSONString(order);
        long userid = order.getOname();
        return false;
    }
}
