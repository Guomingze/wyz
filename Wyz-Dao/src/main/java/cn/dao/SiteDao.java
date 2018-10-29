package cn.dao;

import cn.pojo.Site;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface SiteDao {
    /**
     * 查找用户的收货地址
     *
     * @param st 地址对象
     * @return 地址对象集合
     */
    List<Site> address(Site st);

    /**
     * 增加一条收货地址
     *
     * @param st 地址对象
     * @return 受影响行数
     */
    int addaddress(Site st);

    /**
     * 修改收货地址
     *
     * @param st 地址对象
     * @return 受影响行数
     */
    int amendaddress(Site st);

    /**
     * 修改地址状态 1为未删除 0为已删除
     *
     * @param st 地址对象
     * @return 受影响行数
     */
    int deleteaddress(Site st);

    /**
     * 装填Site实体类对象
     * @param rs 结果集
     * @return Site对象
     */
    List<Site> uti(ResultSet rs) throws SQLException;

}
