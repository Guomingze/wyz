package cn.service;

import cn.pojo.Site;
import cn.util.LianZha;

import java.util.List;

public interface SiteService {
    /**
     * 根据用户id查找收货地址
     *
     * @param suid 用户id
     * @return 收货地址集合对象
     */
    List<LianZha> address(int suid);

    /**
     * 新增一条收货地址
     *
     * @param st 收货地址对象
     * @return 搜影响行数
     */
    int addaddress(Site st);

    /**
     * 根据地址id 修改收货地址
     *
     * @param saddress 要修改的收货地址
     * @param sid      地址id
     * @return 修改成为true 修改失败为falses
     */
    boolean amendaddress(String phone,String saddress, int sid);

    /**
     * 根据地址id修改地址状态 1为未删除 0为已删除
     * @param sid 地址id code登录凭证
     * @return 修改成为true 修改失败我为falses
     */
    String deleteaddress(int sid,String code);
}
