package com.cg.baitap.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MoneySevlet",value = "/convert")
public class MoneyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/money.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float rate =Float.parseFloat(req.getParameter("rate"));
        float usd =Float.parseFloat(req.getParameter("usd"));
        float vnd = rate * usd;
//        PrintWriter writer = resp.getWriter();
//        writer.println("<html>");
//        writer.println("Rate :" + rate);
//        writer.println("Usd :" + usd);
//        writer.println("Vnd" + vnd);
//        writer.println("</html>");
        req.setAttribute("vnd", vnd);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/money.jsp");
        requestDispatcher.forward(req, resp);
    }
}
