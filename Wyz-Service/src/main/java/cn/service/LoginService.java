package cn.service;

import cn.pojo.Users;

public interface LoginService {
    /**
     * 根据用户唯一标识判断用户是否存在
     * @param code 用户唯一标识
     * @return 存在（true）不存在（false）
     */
    boolean userIsExist(String code);

    /**
     * 生成用户唯一标识
     * @param code 登录时产生的code
     * @return 用户唯一标识
     */
    String getOpenid(String code);

    /**
     * 添加用户
     * @param openid 用户唯一标识
     * @return 添加是否成功
     */
    boolean addUser(String openid);

    /**
     * 根据code获取用户对象
     * @param code
     * @return 用户对象
     */
    Users getUser(String code);

    /**
     * 添加用户信息
     * @param users
     * @return
     */
    boolean addUserInfo(Users users);
}
