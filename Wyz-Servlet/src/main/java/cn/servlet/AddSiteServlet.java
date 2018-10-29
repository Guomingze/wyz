package cn.servlet;

import cn.pojo.Site;
import cn.service.LoginService;
import cn.service.SiteService;
import cn.service.impl.LoginServiceImpl;
import cn.service.impl.SiteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddSiteServlet", urlPatterns = "/AddSiteServlet")
public class AddSiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("appplication/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        LoginService loginService = new LoginServiceImpl();
        if (code != null && !"".equals(code) && !"undefined".equals(code)) {
            address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
            int uid = (int) loginService.getUser(code).getUid();
            Site site = new Site();
            site.setSuid(uid);
            site.setSaddress(address);
            site.setSphone(phone);
            SiteService siteService = new SiteServiceImpl();
            int count = siteService.addaddress(site);
            if (count > 0) {
                out.print("添加成功");
            } else {
                out.print("添加失败");
            }
        }
        out.flush();
        out.close();
    }
}
