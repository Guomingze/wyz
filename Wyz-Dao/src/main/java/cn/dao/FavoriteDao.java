package cn.dao;

import cn.pojo.Favorite;
import cn.pojo.Pshoping;
import cn.pojo.Users;

import java.util.List;

public interface FavoriteDao {
    /**
     * 添加收藏
     * @param favorite 收藏对象
     * @return 影响行数
     */
    int addFavorite(Favorite favorite);

    /**
     * 删除收藏
     * @param favorite 收藏对象
     * @return 影响行数
     */
    int deleteFavorite(Favorite favorite);

    /**
     * 根据用户获取收藏对象集合
     * @param users 用户对象
     * @return 收藏对象集合
     */
    List<Favorite> getUserFavorite(Users users);

    /**
     * 根据商品ID获取收藏对象集合
     * @param pshoping 商品对象
     * @return 收藏对象集合
     */
    List<Favorite> getShopingFavorite(Pshoping pshoping);
}
