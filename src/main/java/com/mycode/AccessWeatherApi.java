/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycode;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonValue;
import javax.json.stream.JsonParser;

/**
 *
 * @author ryo
 */
public class AccessWeatherApi {    
    private JsonReader json;
    InputStream input;

    public AccessWeatherApi() throws MalformedURLException, IOException {
        System.out.println("kokokok");
        this.input = new URL("http://api.openweathermap.org/data/2.5/weather?id=1850144&APPID=").openStream();
        JsonReader reader = Json.createReader(this.input);
        //JSONデータからのオブジェクト・モデルの作成
        JsonStructure read = reader.read();
        //オブジェクト・モデルの参照
        System.out.println(read);
        //↑ここまでおｋ
        System.out.println(read.getValueType());
        JsonObject object = (JsonObject) read;
        JsonObject get = (JsonObject) object.get("coord");
        System.out.println(get.getInt("lat"));
        //きたー！！！//キャストはこのように書く(JsonObject) object.get("coord");
        
    }
    
    
}
