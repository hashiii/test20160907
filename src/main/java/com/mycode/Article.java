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

    //private static final Article art = new Article();
    //connect to datas
    public Article() {
        datas = new ConnectDatas();
    }

    public int getNumberOfAllAricleCounts() throws SQLException, ClassNotFoundException, URISyntaxException {
        AccessToDatabase atc = new AccessToDatabase();
        return atc.getDataFromDatabase();
    }

    public int getTotalArticlesNumber() {
        int numtest = totalArticlesNumber;
        return numtest;
    }

    public Map getArticleContents() throws SQLException, ClassNotFoundException, URISyntaxException {
        AccessToDatabase atc = new AccessToDatabase();
        Map testmap = atc.getContents();
        
        //ここでしすｓテムだそう。
        for (Iterator it = testmap.entrySet().iterator(); it.hasNext();) {
            Map.Entry<Integer, LinkedHashMap> entry = (Map.Entry<Integer, LinkedHashMap>) it.next();
            LinkedHashMap test = entry.getValue();//ここでvaleが持つmapがキテルはあず
//            System.out.println(entry.getKey());
//            System.out.println(test);
            
            //maptest = testmap.value();
        }
//        Iterator<Map.Entry<Integer, String>> entries = testmap.entrySet().iterator();
//        while (entries.hasNext()) {
//        Map.Entry<Integer, String> entry = entries.next();
//        System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
//        }
        return testmap;
        //return atc.getContents();
    }
}
