package cn.servlet;

import cn.pojo.Site;
import cn.pojo.Users;
import cn.service.LoginService;
import cn.service.SiteService;
import cn.service.impl.LoginServiceImpl;
import cn.service.impl.SiteServiceImpl;
import cn.util.LianZha;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SiteServlet", urlPatterns = "/SiteServlet")
public class SiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("UTF-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        if (code != null && !"".equals(code) && !"undefined".equals(code)) {
            SiteService siteService = new SiteServiceImpl();
            LoginService loginService = new LoginServiceImpl();
            Users users = loginService.getUser(code);
            Integer uid = null;
            if (users != null) {
                uid = (int) users.getUid();
            }
            List<LianZha> siteList = siteService.address(uid);
            Object obj = JSON.toJSON(siteList);
            out.print(obj);
        }
        out.flush();
        out.close();
    }
}
