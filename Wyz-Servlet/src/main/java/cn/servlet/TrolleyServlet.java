package cn.servlet;

import cn.pojo.Trolley;
import cn.pojo.Users;
import cn.service.LoginService;
import cn.service.TrolleyService;
import cn.service.impl.LoginServiceImpl;
import cn.service.impl.TrolleyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TrolleyServlet",urlPatterns = "/TrolleyServlet")
public class TrolleyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        TrolleyService trolleyService = new TrolleyServiceImpl();
        String code = request.getParameter("code");
        String tpid = request.getParameter("tpid");
        String tnumber = request.getParameter("tnumber");
        Trolley trolley = new Trolley();
        if (code != null && !"".equals(code) && !"undefined".equals(code)){
            LoginService loginService = new LoginServiceImpl();
            Users users = loginService.getUser(code);
            Integer uid = null;
            if(users != null){
                uid = (int) users.getUid();
            }
            Integer pid = new Integer(tpid);
            Integer number = new Integer(tnumber);
            trolley.setTuid(uid);
            trolley.setTpid(pid);
            trolley.setTnumber(number);
        }
        int count = trolleyService.addshopping(trolley);
        if(count > 0){
            out.print("添加成功");
        }else{
            out.print("添加失败");
        }
        out.flush();
        out.close();
    }
}
