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

@WebServlet(name = "UpdateSiteServlet", urlPatterns = "/UpdateSiteServlet")
public class UpdateSiteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String uid = request.getParameter("uid");
        boolean flag = true;
        if (address != null && !"".equals(address) && !"undefined".equals(address)) {
            address = new String(address.getBytes("ISO-8859-1"), "UTF-8");
            phone = new String(phone.getBytes("ISO-8859-1"), "UTF-8");
            Integer uid1 = new Integer(uid);
            SiteService siteService = new SiteServiceImpl();
            flag = siteService.amendaddress(phone, address, uid1);
        }
        if (flag) {
            out.print("修改成功");
        } else {
            out.print("修改失败");
        }
        out.flush();
        out.close();
    }
}
