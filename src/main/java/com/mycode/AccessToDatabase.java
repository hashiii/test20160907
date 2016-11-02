/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycode;

import java.beans.Statement;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ryo
 */
public class AccessToDatabase {
     //String url =  "jdbc:postgresql://localhost/postgres";
    String url = "jdbc:postgresql://ec2-23-23-226-41.compute-1.amazonaws.com:5432/d4ppsmhem0c3dv";
     //String user = "postgres";
     String user = "srzpgehvjaipad";
     //String password = "postgres";
     int numberOfRow = 0;
     String password = "CH-M4-l4EC9xR72a-6i5F-YAH_";
    //これはどっから？
     String odateturo = "jdbc:postgresql://ec2-23-23-226-41.compute-1.amazonaws.com:5432/d4ppsmhem0c3dv?sslmode=require&user=srzpgehvjaipad&password=CH-M4-l4EC9xR72a-6i5F-YAH_&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory";
     //numberOfRow = 0;
     

    public AccessToDatabase() throws SQLException, ClassNotFoundException, URISyntaxException {
        // ドライバクラスをロード 
        Class.forName("org.postgresql.Driver"); // PostgreSQLの場合 
        //Connection con = DriverManager.getConnection(url, user, password);
        Connection con = DriverManager.getConnection(odateturo);
        //URI dbUri = new URI(System.getenv("postgres://srzpgehvjaipad:CH-M4-l4EC9xR72a-6i5F-YAH_@ec2-23-23-226-41.compute-1.amazonaws.com:5432/d4ppsmhem0c3dv"));
         
    //String username2 = dbUri.getUserInfo().split(":")[0];
    //String password2 = dbUri.getUserInfo().split(":")[1];
    //String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
    //Connection con = DriverManager.getConnection(dbUrl, username, password);
    //System.out.println(dbUrl);
        //Connection con = DriverManager.getConnection(url);
        System.out.print("conection ok");
        ResultSet executeQuery;
        try (java.sql.Statement stmt = con.createStatement() //なぜこの書き方？
        ) {
            String sql = "select * FROM notebook_posts;";
            // テーブル照会実行
            executeQuery = stmt.executeQuery(sql);
            while (executeQuery.next()) {
                //int code = executeQuery.getInt("code");
                String company = executeQuery.getString("post_title");
                System.out.println("コード 会社名:" + company);
                numberOfRow ++;
                System.out.println(new Integer(numberOfRow).toString());
            }
            //executeQuery.last();
        }
        executeQuery.close();
        
        
    }
    
    public int getDataFromDatabase() throws SQLException, ClassNotFoundException{
        System.out.println(new Integer(numberOfRow).toString());
        return numberOfRow;
        }
    //この書き方だめっぽい。
//        public ResultSet getDataFromDatabase() throws SQLException, ClassNotFoundException{
//        Class.forName("org.postgresql.Driver"); // PostgreSQLの場合 
//        Connection con = DriverManager.getConnection(url, user, password);
//        System.out.print("conection ok");
//        ResultSet executeQuery;
//         try (java.sql.Statement stmt = con.createStatement() //なぜこの書き方？
//         ) {
//             String sql = "select * FROM playground;";
//             // テーブル照会実行
//             executeQuery = stmt.executeQuery(sql);
//         }
//        return executeQuery;
//    }
}
