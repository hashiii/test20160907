package com.mycode;

public class Article {
    public int totalArticlesNumber = 1234;
    ConnectDatas datas;
    
    
    //private static final Article art = new Article();
    //connect to datas
    public Article(){
      datas = new ConnectDatas();
    }
    
    public int intest(){
        return 0;
    }
    
    public int getTotalArticlesNumber(){
        int numtest = totalArticlesNumber;
        return numtest;
        //return 777;//temporaty
    }
}
