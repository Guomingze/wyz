package cn.servlet;

import cn.pojo.Users;
import cn.service.LoginService;
import cn.service.impl.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AddUserInfoServlet",urlPatterns = "/AddUserInfoServlet")
public class AddUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String code = request.getParameter("code");
        boolean flag = false;
        if (username != null && !"".equals(username) && !"undefined".equals(username)) {
            username = new String(username.getBytes("ISO-8859-1"),"UTF-8");
            address = new String(address.getBytes("ISO-8859-1"),"UTF-8");
            Users users = new Users();
            users.setUname(username);
            users.setUdelivery(address);
            LoginService loginService = new LoginServiceImpl();
            Users users1 = loginService.getUser(code);
            users.setUid(users1.getUid());
            users.setUpassword(users1.getUpassword());
            users.setUsex(users1.getUsex());
            users.setUphone(users1.getUphone());
            users.setU1(users1.getU1());
            users.setU2(users1.getU2());
            users.setU3(users1.getU3());
            flag = loginService.addUserInfo(users);
        }
        PrintWriter out = response.getWriter();
        if(flag){
            out.print("添加成功");
        }else{
            out.print("添加失败");
        }
        out.flush();
        out.close();
    }
}
