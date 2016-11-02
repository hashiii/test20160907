<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycode.Article" %>


<%

//int shop = Article.getTotalArticlesNumber();
Article artest = new Article();
//List<String> values = new ArrayList<String>();


int numberOfAllArticleCount = artest.intest();
%>
<h1>My Notebook<h1>

<section>Latest post_<section>

<p>
    Now ,
<%= numberOfAllArticleCount  %> article exists!
</p>

<a href = "post.jsp">post article</a>