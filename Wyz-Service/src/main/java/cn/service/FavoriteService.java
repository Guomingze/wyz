package cn.service;

import cn.pojo.Users;

public interface FavoriteService {
    /**
     * 根据商品id和用户对象判断此商品是否存在
     * @param shopingid 商品id
     * @param us 用户对象
     * @return 存在fals 不存在true
     */
    boolean collect (long shopingid, Users us);
}
