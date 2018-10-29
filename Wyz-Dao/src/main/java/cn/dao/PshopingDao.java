package cn.dao;

import cn.pojo.Pshoping;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface PshopingDao {
    /**
     * 查询全部商品
     * @return 全部商品集合
     */
    List<Pshoping> allPshopings(Pshoping p);

    /**
     * 添加商品
     * @param pshoping 商品对象
     * @return 影响行数
     */
    int addPshoping(Pshoping pshoping);

    /**
     * 更改商品信息
     * @param pshoping 商品对象
     * @return 影响行数
     */
    int updatePshoping(Pshoping pshoping);

    /**
     * 模糊查询
     * @param
     * @return
     */
    List<Pshoping> selectDimShoping(Pshoping pshoping);

    /**
     * 分页
     * @param pshoping
     * @param count1
     * @param count2
     * @return
     */

    List<Pshoping> fenye(@Param("pshoping") Pshoping pshoping,@Param("count1") int count1,@Param("count2") int count2);
}






