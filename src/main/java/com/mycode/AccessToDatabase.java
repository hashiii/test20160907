/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycode;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ryo
 */
public class AccessToDatabase {
     String url =  "jdbc:postgresql://localhost/postgres";
     String user = "postgres";
     String password = "postgres";
     

    public AccessToDatabase() throws SQLException, ClassNotFoundException {
        // ドライバクラスをロード 
        Class.forName("org.postgresql.Driver"); // PostgreSQLの場合 
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.print("conection ok");
        java.sql.Statement stmt = con.createStatement();//なぜこの書き方？
        String sql = "select * FROM playground;";
        // テーブル照会実行
        ResultSet executeQuery = stmt.executeQuery(sql);
        while(executeQuery.next()){
            //int code = executeQuery.getInt("code");
            String company = executeQuery.getString("color");
            System.out.println("コード 会社名:" + company);
        }
        stmt.close();
        executeQuery.close();
        
        
    }
}
