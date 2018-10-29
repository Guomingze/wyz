package cn.servlet;

import cn.pojo.Trolley;
import cn.pojo.Users;
import cn.service.LoginService;
import cn.service.TrolleyService;
import cn.service.impl.LoginServiceImpl;
import cn.service.impl.TrolleyServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 返回指定用户的购物车信息
 */
@WebServlet(name = "AllTrolleyServlet", urlPatterns = "/AllTrolleyServlet")
public class AllTrolleyServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        Integer uid1 = 0;
        if (code != null && !"null".equals(code) && !"".equals(code) && !"undefined".equals(code)) {
            LoginService loginService = new LoginServiceImpl();
            Users users = loginService.getUser(code);
            if (users != null) {
                uid1 = (int) users.getUid();
            }
        }
        TrolleyService trolleyService = new TrolleyServiceImpl();
        List<Trolley> trolleyList = trolleyService.shopping(uid1);
        Object obj = JSON.toJSON(trolleyList);
        out.print(obj);
        out.flush();
        out.close();
    }
}
