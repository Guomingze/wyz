package cn.servlet;

import cn.pojo.Order;
import cn.pojo.Orderll;
import cn.service.BuyService;
import cn.service.impl.BuyServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "OrderServlet",urlPatterns = "/OderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String code = request.getParameter("code");
        String state = request.getParameter("state");
        if(code != null && !"".equals(code) && !"undefined".equals(code)){
            if(state != null && !"".equals(state) && !"undefined".equals(state)){
                Integer state1 = new Integer(state);
                BuyService buyService = new BuyServiceImpl();
                List<Orderll> orderList = buyService.seletAll(code, state1);
                out.print(JSON.toJSON(orderList));
            }
        }
        out.flush();
        out.close();
    }
}
