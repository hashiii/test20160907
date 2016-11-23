<%@ page import="java.util.ArrayList" %>
<%@ page import="com.mycode.Article" %>
<%@ page import="java.util.*" %>
<%@ page import="static jdk.nashorn.internal.objects.NativeArray.map" %>
<%@ page contentType="text/html; charset=UTF-8" %>

<%
Article artest = new Article();
int numberOfAllArticleCount = artest.getNumberOfAllAricleCounts();
Map contents = artest.getArticleContents();
%>


<!DOCTYPE html>

<header>
    <script type='text/javascript' src='<%= org.webjars.AssetLocator.getWebJarPath("jquery.js") %>'></script>    
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My Notebook !</title>
    <style type="text/css">
        .aricle_contents{
            -moz-box-shadow: 0 0 2px black;
            -webkit-box-shadow: 0 0 2px black;
            box-shadow: 0 0 2px black;
            padding: 10px;
        }
        .header_title{
            background-color: #174364;
            padding: 20px;
            color:	#D5AD6D; /*if no support for background-clip*/
        }
    </style>
</header>
<body>
    <header class="jumbotron header_title">
        <div class="container-fluid">
            <h1>My Notebook</h1>
        </div>
    </header>
    <div class="container">
        <div class="row">
            <div class="col-md-8">
                <section>
                    <p>
                        Now ,
                        <%= numberOfAllArticleCount  %> article exists!
                    </p>
                    <div><a href = "post.jsp">Post article</a></div>
                    <h1>Articles List</h1>

                    <section>
                        <% 
                         for (Iterator it = contents.entrySet().iterator(); it.hasNext();) {
                             Map.Entry<Integer, LinkedHashMap> entry = (Map.Entry<Integer, LinkedHashMap>) it.next();
                             LinkedHashMap article = entry.getValue();
                        %>
                        <h1>
                            <%= article.get("title")  %> 
                        </h1>
                        <div class="aricle_contents">
                            <p>
                                <%= article.get("content")  %> 
                            </p>
                        </div>
                        <div>
                            <small><%= article.get("timestamp")  %> </small>
                        </div>
                        <%
                        }
                        %>

                    </section>
                </section>

            </div>
            <div class="col-md-4">
                <h2>category</h2>
            </div>
        </div>

    </div>
</body>

</html>