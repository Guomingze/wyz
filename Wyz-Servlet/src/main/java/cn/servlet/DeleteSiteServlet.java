package cn.servlet;

import cn.service.SiteService;
import cn.service.impl.SiteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteSiteServlet", urlPatterns = "/DeleteSiteServlet")
public class DeleteSiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String sid = request.getParameter("sid");
        String mess = "";
        if (code != null && !"".equals(code) && !"undefined".equals(code)) {
            if (sid != null && !"".equals(sid) && !"undefined".equals(sid)) {
                Integer integer = new Integer(sid);
                SiteService siteService = new SiteServiceImpl();
                mess = siteService.deleteaddress(integer, code);
            }
        }
        out.print(mess);
        out.flush();
        out.close();
    }
}
