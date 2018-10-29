package cn.servlet;

import cn.pojo.Users;
import cn.service.LoginService;
import cn.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录
 */
@javax.servlet.annotation.WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json charset=utf-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("codeid");
        LoginService loginService = new LoginServiceImpl();
        Users users = loginService.getUser(code);
        long uid = 0;
        if (users != null) {
            uid = users.getUid();
        }
        out.print(uid);
        out.flush();
        out.close();
    }
}
