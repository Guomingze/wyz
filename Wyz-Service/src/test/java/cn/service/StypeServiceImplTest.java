package cn.service;


import cn.service.impl.SiteServiceImpl;

public class StypeServiceImplTest {
    static SiteService siteService = new SiteServiceImpl();

    public static void main(String[] args) {
        boolean flag = siteService.amendaddress("18403415200","呵呵哒",1);
        System.out.println(flag ? "成功":"失败");
    }
}