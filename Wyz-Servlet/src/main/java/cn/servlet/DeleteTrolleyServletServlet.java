package cn.servlet;

import cn.service.TrolleyService;
import cn.service.impl.TrolleyServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteTrolleyServletServlet", urlPatterns = "/DeleteTrolleyServletServlet")
public class DeleteTrolleyServletServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String tid = request.getParameter("tid");
        Integer tid1 = 0;
        if (tid != null && !"".equals(tid) && !"undefined".equals(tid)) {
            tid1 = new Integer(tid);
        }
        TrolleyService trolleyService = new TrolleyServiceImpl();
        int count = trolleyService.deleteshopping(tid1);
        if (count > 0) {
            out.print("删除成功");
        } else {
            out.print("删除失败");
        }
        out.flush();
        out.close();
    }
}
