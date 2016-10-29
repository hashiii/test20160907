<%-- 
    Document   : post
    Created on : 2016/10/27, 20:23:14
    Author     : dev
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1><h:outputText value="Hello World!"/></h1>
            <form action="notebookServlet" method="post">
                <div>title</div>
                <input type ="textbox" name="title">
                <div>text</div>
                <textarea name="text"></textarea>
                <input type="submit" value="post!">
            </form>
        </body>
    </html>
</f:view>
