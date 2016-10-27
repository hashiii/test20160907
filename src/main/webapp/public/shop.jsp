<%@ page import="java.util.List" %>
<%@ page import="com.mycode.Fruits" %>
<%@ page import="com.mycode.FruitsShop" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Fruitsのお店</title>
        <meta charset="UTF-8">
        <style>
            <%@ include file="css/custom.css" %>
        </style>
    </head>
    <body>
        <h2>Fruitsのお店</h2>
        <%
            Fruits flt = new Fruits("aaa",111);
            FruitsShop shop = FruitsShop.getShop();
            List<Fruits> fruitsList = shop.getFruitsList();
        %>
        <p>お店にはFruitsが
            <%=fruitsList.size() %>
            個登録されています。</p>
        <table>
            <tr>
                <th>商品名</th>
                <th>価格</th>
            </tr>
            <% for(Fruits fruits : fruitsList){ %>
            <tr>
                <td><%=fruits.getName() %></td>
                <td><%=fruits.getPrice() %></td>
            </tr>
            <% } %>
        </table>
        <p><a href="input.jsp">商品を登録する</a></p>
    </body>
</html>

