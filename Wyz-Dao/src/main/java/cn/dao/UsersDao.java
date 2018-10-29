package cn.dao;

import cn.pojo.Users;

public interface UsersDao {
    /**
     * 根据Users对象查询是否存在
     * @param user
     * @return 存在：Users对象 不存在：null
     */
    Users isExist(Users user);

    /**
     * 根据用户ID查询用户对象
     * @param id
     * @return 对应ID的用户对象
     */
    Users getUser(int id);

    /**
     * 添加用户
     * @param u 用户对象
     * @return 影响行数
     */
    int addUser(Users u);

    /**
     * 删除用户（更改状态)
     * @param u 用户对象
     * @return 影响行数
     */
    int delete(Users u);

    /**
     * 修改用户信息
     * @param users 用户对象
     * @return 影响行数
     */
    int amendUser(Users users);

    /**
     * 根据code查询用户对象
     * @param users
     * @return 用户对象
     */
//    Users getuser(Users users);
}
