<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycode.Article" %>
<%@ page import="java.util.*" %>
<%@ page import="static jdk.nashorn.internal.objects.NativeArray.map" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%

//int shop = Article.getTotalArticlesNumber();
Article artest = new Article();
//List<String> values = new ArrayList<String>();
//Map<K, V> map = new LinkedHashMap<K, V>();


int numberOfAllArticleCount = artest.getNumberOfAllAricleCounts();
Map contents = artest.getArticleContents();
%>
<h1>My Notebook<h1>

<section>Latest post_日本<section>

<p>
    Now ,
<%= numberOfAllArticleCount  %> article exists!
</p>

<section>
    <div>
       <% 
        //Collection collection = contents.values();
        //Iterator<Map.Entry<Integer, String>> entries = contents.entrySet().iterator();
//        while (entries.hasNext()) {
//        Map.Entry<Integer, String> entry = entries.next();
        for (Iterator it = contents.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, LinkedHashMap> entry = (Map.Entry<Integer, LinkedHashMap>) it.next();
            LinkedHashMap article = entry.getValue();
        %>
        <h2>
            <%= article.get("title")  %> 
        </h2>
        <div>
            <%= article.get("content")  %> 
        </div>
        <div>
            <%= article.get("timestamp")  %> 
        </div>
        <%
            //System.out.println(test.get("title"));
        //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
       %>
        
    </div>
</section>

<a href = "post.jsp">post article</a>