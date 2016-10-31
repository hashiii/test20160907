package com.mycode;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Article {
    public int totalArticlesNumber = 1234;
    ConnectDatas datas;
    
    
    //private static final Article art = new Article();
    //connect to datas
    public Article(){
      datas = new ConnectDatas();
    }
    
    public int intest() throws SQLException, ClassNotFoundException{
        //return 0;
        AccessToDatabase atc = new AccessToDatabase();
//        ResultSet dataFromDatabase = atc.getDataFromDatabase();
//        System.out.println("1111111111");
//        //件数を取得する処理
//        dataFromDatabase.last();
//        int numberOfRow = dataFromDatabase.getRow();
//        System.out.println("4444444444");
        return atc.getDataFromDatabase();
    }
    
    public int getTotalArticlesNumber(){
        int numtest = totalArticlesNumber;
        return numtest;
        //return 777;//temporaty
    }
}
