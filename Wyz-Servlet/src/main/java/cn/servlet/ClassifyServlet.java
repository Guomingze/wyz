package cn.servlet;

import cn.pojo.Pshoping;
import cn.pojo.Type;
import cn.service.StypeService;
import cn.service.impl.StypeServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;

/**
 * 分类展示
 */
@WebServlet(name = "ClassifyServlet", urlPatterns = "/ClassifyServlet")
public class ClassifyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json charset=utf-8");
        PrintWriter out = response.getWriter();
        StypeService stypeService = new StypeServiceImpl();
        String typeid = null;
        typeid = request.getParameter("typeid");
        if (typeid == null || "".equals(typeid)) {
            List<Type> typeList = stypeService.getAlltyp();
            Object obj = JSON.toJSON(typeList);
            out.print(obj);
        } else {
            Integer typeidd = new Integer(typeid);
            Type type = new Type();
            type.setTid(typeidd);
            List<Pshoping> pshopingList = stypeService.getAllType(type);
            Object obj = JSON.toJSON(pshopingList);
            out.print(obj);
        }
        out.flush();
        out.close();
    }
}
