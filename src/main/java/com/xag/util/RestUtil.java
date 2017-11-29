package com.xag.util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author agunga
 */
public class RestUtil {

    private static ResponseObject responseObj = new ResponseObject();

    public static ResponseObject setResponseObject(boolean status, Object data) {
        ResponseObject ro = responseObj;
        ro.setStatus(status);
        ro.setMessage(status ? "Success" : "Failed");
        ro.setData(data);
        return ro;
    }

}
