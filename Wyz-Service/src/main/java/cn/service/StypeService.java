package cn.service;

import cn.pojo.Pshoping;
import cn.pojo.Type;

import java.util.List;

public interface StypeService {
    /**
     * 获取对应类型的所有商品
     * @return 商品的集合
     */
    List<Pshoping> getAllType(Type type);

    /**
     *  获取所有类型
     * @return 所有类型的对象集合
     */
    public List<Type> getAlltyp();

}
