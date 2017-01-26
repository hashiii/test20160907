/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycode;

import static com.google.common.base.CharMatcher.is;
import com.google.common.io.Files;
import java.beans.Statement;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import sun.misc.IOUtils;

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
    LinkedHashMap hashdata;
    String aritleTitle;
    String aritleContent;
    String timestamp;
    Blob image;
    String key;
    LinkedHashMap<Integer, LinkedHashMap<String, String>> outerMap = new LinkedHashMap<Integer, LinkedHashMap<String, String>>();
    LinkedHashMap<String, String> innerMap;
    Connection con;
    ResultSet executeQuery;
    String imageBase64;
    private String value;

    public AccessToDatabase() throws SQLException, ClassNotFoundException, URISyntaxException, IOException, JspException {
        // ドライバクラスをロード 
        Class.forName("org.postgresql.Driver"); // PostgreSQLの場合 
        //Connection con = DriverManager.getConnection(url, user, password);//localの場合
        con = DriverManager.getConnection(odateturo);
        hashdata = new LinkedHashMap();

        try (java.sql.Statement stmt = con.createStatement()) {
            String sql = "select * FROM notebook_posts where status = 'active' ORDER BY post_timestamp DESC ;";
            // テーブル照会実行
            executeQuery = stmt.executeQuery(sql);
            while (executeQuery.next()) {
                innerMap = new LinkedHashMap<String, String>();
                numberOfRow++;
                aritleTitle = executeQuery.getString("post_title");
                aritleContent = executeQuery.getString("post_content");

                JspWriter writer = null;
                // 改行コードを全てLFに変換し、LFでsplit
                //リプレイスしたら全て\nになるからその条件でsplitする。

                //改行処理追加
                String addedNewLinesAritleContent = "";
                for (String str : aritleContent.replaceAll("\r\n", "\n").replaceAll("\r", "\n").split("\n")) {
                    addedNewLinesAritleContent += "<p>";
                    addedNewLinesAritleContent += str;
                    addedNewLinesAritleContent += "</p>";
                }

                timestamp = executeQuery.getString("post_timestamp");
                InputStream binaryStream = executeQuery.getBinaryStream("image");
                key = executeQuery.getString("key");
                hashdata.put(numberOfRow, aritleTitle);
                innerMap.put("title", aritleTitle);
                innerMap.put("content", addedNewLinesAritleContent);
                innerMap.put("timestamp", timestamp);

                InputStream inputStream1 = binaryStream;

                ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                if (inputStream1 != null) {
                    int nRead;
                    byte[] data = new byte[16384];
                    while ((nRead = inputStream1.read(data, 0, data.length)) != -1) {
                        buffer.write(data, 0, nRead);
                    }
                    buffer.flush();
                    byte[] toByteArray = buffer.toByteArray();

                    imageBase64 = new String(Base64.getEncoder().encode(toByteArray));
                    if (imageBase64.isEmpty()) {//if 0byte then 
                        imageBase64 = null;
                    }
                } else {
                    imageBase64 = null;
                }
                innerMap.put("image", imageBase64);
                //
                innerMap.put("key", key);
                outerMap.put(numberOfRow, innerMap);
            }
        }
        executeQuery.close();

    }

    public void postDataToDatabase(HttpServletRequest request) throws SQLException, FileNotFoundException, IOException, ServletException, ParseException {
        // 1) create a java calendar instance
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Tokyo"));
        // 2) get a java.util.Date from the calendar instance.
        java.util.Date now = calendar.getTime();
        // 3) a java current time (now) instance
        java.sql.Timestamp currentTimestamp = new java.sql.Timestamp(now.getTime());//finish
        //chage to String
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //simpleDateFormat.setTimeZone(tzTest);//タイムゾーンの設定いらない?
        String timestamp = simpleDateFormat.format(currentTimestamp);
        Part part = request.getPart("image");//image update
        InputStream inputStream = part.getInputStream();
        ByteArrayOutputStream buffer = new ByteArrayOutputStream();

        int nRead;
        byte[] data = new byte[16384];

        while ((nRead = inputStream.read(data, 0, data.length)) != -1) {
            buffer.write(data, 0, nRead);
        }

        buffer.flush();

        byte[] toByteArray = buffer.toByteArray();

        String sql = "insert into notebook_posts (post_title,post_content,post_timestamp,image) values (?,?,?,?);";
        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setString(1, request.getParameter("title"));
            statement.setString(2, request.getParameter("text"));
            statement.setTimestamp(3, currentTimestamp, calendar);
            statement.setBytes(4, toByteArray);

            int row = statement.executeUpdate();
        }
    }

    public void deleteDatatoDatabase(String keynumber) throws SQLException {
        //String sql = "delete from notebook_posts where key = " + keynumber;
        String sql = "update notebook_posts set status = 'invalid' where key = " + keynumber;
        java.sql.Statement resultStmt;
        resultStmt = con.createStatement();
        resultStmt.execute(sql);

    }

    public int getDataFromDatabase() throws SQLException, ClassNotFoundException {
        return numberOfRow;
    }

    public LinkedHashMap getContents() {
        return outerMap;
    }
}
