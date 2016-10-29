/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycode;

import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author ryo
 */
public class FileController {
    private FileWriter fw;

    public FileController(HttpServletRequest request) throws IOException {
        
        this.fw = new FileWriter("test2.txt");
        fw.write(request.getParameter("title"));
        fw.close();
    }
}
