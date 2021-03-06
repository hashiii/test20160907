package com.mycode;

import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.jsp.JspException;
import static jdk.nashorn.internal.objects.NativeArray.map;

public class Article {

    public int totalArticlesNumber = 1234;
    ConnectDatas datas;
    LinkedHashMap maptest;

    //connect to datas
    public Article() {
        datas = new ConnectDatas();
    }

    public int getNumberOfAllAricleCounts() throws SQLException, ClassNotFoundException, URISyntaxException, IOException, JspException {
        AccessToDatabase atc = new AccessToDatabase(0);
        return atc.getDataFromDatabase();
    }

    public Map getArticleContents(int pageNum) throws SQLException, ClassNotFoundException, URISyntaxException, IOException, JspException {

        AccessToDatabase atc = new AccessToDatabase(pageNum);
        Map eachArticleDatas = atc.getContents();
        return eachArticleDatas;
    }

    public void delete(String keynumber) throws SQLException, ClassNotFoundException, URISyntaxException, IOException, JspException {
        AccessToDatabase db = new AccessToDatabase(0);
        db.deleteDatatoDatabase(keynumber);
    }
}
