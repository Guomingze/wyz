package cn.service;

import cn.pojo.Trolley;

import java.util.List;

public interface TrolleyService {
    /**
     * 根据用户id查找购物车
     *
     * @param tuid 用户id
     * @return 购物车集合对象
     */
    List<Trolley> shopping(int tuid);

    /***
     *新增一个购物车对象
     * @param tr 购物车对象
     * @return 受影响行数
     */
    int addshopping(Trolley tr);

    /**
     * 根据id删除购物车对象
     * @param tid 购物车id
     * @return 受影响行数
     */
    int deleteshopping(long tid);
}
