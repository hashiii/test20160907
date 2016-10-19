package com.mycode;

import java.io.IOException;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FruitsServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        String name;
        int price;
        name = request.getParameter("name");
        price = Integer.parseInt(request.getParameter("price"));
        Fruits fruits = new Fruits(name, price);
        FruitsShop shop = FruitsShop.getShop();
        //shop.removeFruits();
        shop.addFruits(fruits);
        response.getWriter().println("<h2>Fruitsを登録しました！sss</h2>");
        response.getWriter().println(shop.getMessage(fruits));
        response.getWriter().println("<p><a href='input.jsp'>また登録する</a> | <a href='shop.jsp?" + new Date().getTime() + "'>お店へ行く</a></p>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().println("<h2>ここはあなたの来るところじゃない！引き返せ！</h2>");
        response.getWriter().println("<p><a href='input.jsp'>登録する</a> | <a href='shop.jsp?" + new Date().getTime() + "'>お店へ行く</a></p>");
    }
}
