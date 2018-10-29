package cn.dao;

import cn.pojo.Type;

import java.util.List;

public interface TypeDao {
    /**
     * 查询所有类型
     * @return 所有类型对象集合
     */
    List<Type> getAllType(Type type);

    /**
     * 添加商品类型
     * @param t 类型对象
     * @return 影响行数
     */
    int addType(Type t);

    /**
     * 删除商品类型 （更改状态）
     * @param t 商品类型对象
     * @return 影响行数
     */
    int deleteType(Type t);

    /**
     * 修改商品类型
     * @param type 商品类型对象
      * @return 影响行数
     */
    int amendType(Type type);
}
