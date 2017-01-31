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
            <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
            <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
            <meta name="viewport" content="width=device-width, initial-scale=1">
            <title>Post Article</title>
        </head>
        <body>
            <div class="container">
                <h1><h:outputText value="Hello World!"/></h1>
                <form action="notebookServlet" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="post_title">Title</label>
                        <input type ="textbox" class="form-control" name="title" id="post_title">
                    </div>
                    <div class ="from-group">
                        <label for="post_text">text</label>
                        <textarea name="text" id="post_text" class="form-control" rows="10"></textarea>
                    </div>
                    <div>
                        <input type="file"  name="image" accept='image/*'>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </body>
    </html>
</f:view>
