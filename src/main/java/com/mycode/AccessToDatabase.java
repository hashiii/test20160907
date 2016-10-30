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
     String url =  "jdbc:postgresql://localhost/sammy";
     String user = "postgres";
     String password = "postgres";
     Connection con;

    public AccessToDatabase() throws SQLException, ClassNotFoundException {
        // ドライバクラスをロード 
        Class.forName("org.postgresql.Driver"); // PostgreSQLの場合 
        this.con = DriverManager.getConnection(url, user, password);
        System.out.print("conection ok");
        // テーブル照会実行
    }
}
