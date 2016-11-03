<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycode.Article" %>
<%@ page import="java.util.*" %>
<%@ page import="static jdk.nashorn.internal.objects.NativeArray.map" %>


<%

//int shop = Article.getTotalArticlesNumber();
Article artest = new Article();
//List<String> values = new ArrayList<String>();
//Map<K, V> map = new LinkedHashMap<K, V>();


int numberOfAllArticleCount = artest.getNumberOfAllAricleCounts();
Map contents = artest.getArticleContents();
%>
<h1>My Notebook<h1>

<section>Latest post_<section>

<p>
    Now ,
<%= numberOfAllArticleCount  %> article exists!
</p>

<section>
    <div>
       <% 
        //Collection collection = contents.values();
        Iterator<Map.Entry<Integer, String>> entries = contents.entrySet().iterator();
        while (entries.hasNext()) {
        Map.Entry<Integer, String> entry = entries.next();
        %>
        <h2>
            <%= entry.getValue() %>
        </h2>
        <div>
            *there will be contain text contents.
        </div>
        <div>
            *there will be contain date contents. example, 2016-11-03-12.12.12.12.
        </div>
        <%
        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
        }
       %>
        
    </div>
</section>

<a href = "post.jsp">post article</a>