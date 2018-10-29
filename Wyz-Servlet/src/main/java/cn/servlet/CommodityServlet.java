package cn.servlet;

import cn.pojo.Pshoping;
import cn.service.CommodityService;
import cn.service.impl.CommodityServiceImpl;
import com.alibaba.fastjson.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 商品详情
 */
@WebServlet(name = "CommodityServlet", urlPatterns = "/CommodityServlet")
public class CommodityServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        String pidStr = request.getParameter("pid");
        Pshoping pshoping = null;
        if (pidStr != null && !"".equals(pidStr)) {
            Integer pid = new Integer(pidStr);
            CommodityService commodityService = new CommodityServiceImpl();
            pshoping = commodityService.getPshoping(pid);
        }
        Object obj = JSON.toJSON(pshoping);
        out.print(obj);
        out.flush();
        out.close();
    }
}
