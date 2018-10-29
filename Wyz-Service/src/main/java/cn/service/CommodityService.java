package cn.service;

import cn.pojo.Pshoping;

public interface CommodityService {
    /**
     * 根据商品ID获取对应的商品对象
     * @param pid 商品ID
     * @return 商品对象
     */
    Pshoping getPshoping(long pid);
    /**
     * 分页展示信息
     * @param page
     * @param psh
     * @return
     */
    String getpage(int page,int psh);
}
