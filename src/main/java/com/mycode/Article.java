package com.mycode;

import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import static jdk.nashorn.internal.objects.NativeArray.map;

public class Article {

    public int totalArticlesNumber = 1234;
    ConnectDatas datas;
    LinkedHashMap maptest ;

    //connect to datas
    public Article() {
        datas = new ConnectDatas();
    }

    public int getNumberOfAllAricleCounts() throws SQLException, ClassNotFoundException, URISyntaxException {
        AccessToDatabase atc = new AccessToDatabase();
        return atc.getDataFromDatabase();
    }    

    public Map getArticleContents() throws SQLException, ClassNotFoundException, URISyntaxException {
        
        AccessToDatabase atc = new AccessToDatabase();
        Map eachArticleDatas = atc.getContents();
        return eachArticleDatas;
    }
}
