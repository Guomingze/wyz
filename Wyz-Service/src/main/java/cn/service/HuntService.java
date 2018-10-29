package cn.service;

import cn.pojo.Pshoping;

import java.util.List;

public interface HuntService {
    /**
     * 模糊查询
     * @param pool 输入的字符
     * @return 查询后的集合
     */
    List<Pshoping> hunt(String pool);

}
