/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.util;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agunga
 */
public class WriteLogsToFile {

    public static void write(String file, String text) {
        PrintWriter writer;
        try {
            writer = new PrintWriter(file, "UTF-8");
            writer.println(text);
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
            Logger.getLogger(WriteLogsToFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
