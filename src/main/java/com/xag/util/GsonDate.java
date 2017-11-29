/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 *
 * @author agunga
 */
public class GsonDate {

    Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
}
