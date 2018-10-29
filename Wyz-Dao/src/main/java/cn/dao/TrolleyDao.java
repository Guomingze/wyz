package cn.dao;

import cn.pojo.Pshoping;
import cn.pojo.Trolley;
import cn.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrolleyDao {
    /**
     * 根据购物车对象查找购物车里的所有商品
     *
     * @param tr 购物车对象
     * @return 购物车集合对象
     */

    List<Trolley> shopping(Trolley tr);

    /**
     * 根据购物车对象查找购物车是否存在此商品
     *
     * @param tr 购物车对象
     * @return 购物车对象
     */
    Trolley seps(Trolley tr);

    /**
     * 根据商品对象修改购物车商品状态
     *
     * @param tr 商品对象
     * @return 受影响行数
     */
    int information(Trolley tr);

    /**
     * 商品对象添加到购物车
     *
     * @param tr
     * @return 受影响行数
     */
    int Addshopping(Trolley tr);

    /**
     * 删除购物对象
     *
     * @return 受影响行数
     */
    int deleteshopping(Trolley tr);
}
