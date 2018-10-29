package cn.servlet;

import cn.service.BuyService;
import cn.service.impl.BuyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "BuyServlet", urlPatterns = "/BuyServlet")
public class BuyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String pid = request.getParameter("pid");
        String num = request.getParameter("num");
        if (code != null && !"".equals(code) && !"undefined".equals(code)) {
            if (pid != null && !"".equals(pid) && !"undefined".equals(pid)) {
                if (num != null && !"".equals(num) && !"undefined".equals(num)) {
                    Integer pid1 = new Integer(pid);
                    Integer num1 = new Integer(num);
                    BuyService buyService = new BuyServiceImpl();
                    int count = buyService.buy(code, pid1, num1);
                    out.print(count > 0 ? "下单成功" : "下单失败");
                } else {
                    out.print("num为空");
                }
            } else {
                out.print("pid为空");
            }
        } else {
            out.print("code为空");
        }
        out.flush();
        out.close();
    }
}
