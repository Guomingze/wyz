package cn.service.impl;

import cn.dao.PshopingDao;
import cn.pojo.Pshoping;
import cn.service.CommodityService;
import cn.util.MyBatisUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
public class CommodityServiceImpl implements CommodityService {
    SqlSession sqlSession = MyBatisUtil.getSqlSession();
    PshopingDao mapper = sqlSession.getMapper(PshopingDao.class);

    @Override
    public Pshoping getPshoping(long pid) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        PshopingDao fd = sqlSession.getMapper(PshopingDao.class);
        Pshoping pshoping = new Pshoping();
        pshoping.setPid(pid);
        List<Pshoping> pshopingList = fd.allPshopings(pshoping);
        return pshopingList.get(0);
    }

    @Override
    public String getpage(int page, int psh) {
        int count1 = (page - 1 ) * psh;//起始行
        Pshoping pshoping = new Pshoping();
        pshoping.setPtype(new Long(psh));

        List<Pshoping> li = mapper.fenye(pshoping, count1,psh);
        JSONArray arr = JSONArray.parseArray(JSON.toJSONString(li));
        if (li != null){
            arr.getJSONObject(0).fluentPut("flag",true);
        }else {
            arr.getJSONObject(0).fluentPut("flag",false);
        }

        return arr.toString();

    }
}
