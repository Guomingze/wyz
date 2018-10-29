package cn.servlet;

import cn.pojo.Pshoping;
import cn.service.impl.HuntServiceImpl;
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
 * 搜索
 */
@WebServlet(name = "HuntServlet", urlPatterns = "/HuntServlet")
public class HuntServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HuntServiceImpl hsi = new HuntServiceImpl();
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json charset=utf-8");
        //搜索内容
        String str = request.getParameter("huntStr");
        str = new String(str.getBytes("ISO-8859-1"), "UTF-8");
        PrintWriter out = response.getWriter();
        //商品集合
        List<Pshoping> pshopings = hsi.hunt(str);
        //生成json对象数组
        Object object = JSON.toJSON(pshopings);
        out.print(object);
        out.flush();
        out.close();
    }
}

