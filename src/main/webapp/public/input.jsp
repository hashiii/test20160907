<%@ page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
    <head>
        <title>Fruitsを登録します</title>
        <meta charset="UTF-8">
        <style>
            <%@ include file="css/custom.css" %>
        </style>
    </head>
    <body>
        <h2>Fruitsを登録</h2>
        <form action="./fruitsServlet" method="POST">
            <table>
                <tr>
                    <th>商品名</th>
                    <td><input type="text" name="name"></input></td>
                </tr>
                <tr>
                    <th>価格</th>
                    <td><input type="text" name="price"></input></td>
                </tr>
            </table>
            <p><input type="submit" value="登録！"></input></p>
        </form>
    </body>
</html>
