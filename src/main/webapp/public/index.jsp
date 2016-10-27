<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycode.Article" %>


<%

//int shop = Article.getTotalArticlesNumber();
Article artest = new Article();
//List<String> values = new ArrayList<String>();


int shop = artest.intest();
%>
<h1>My Notebook<h1>

<section>Latest post<section>


<p>
<%= shop  %>
</p>