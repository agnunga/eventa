package com.ag.action;

import com.ag.model.Admin;
import com.ag.model.Audience;
import com.google.gson.Gson;
import com.xag.util.MyJsonResult;

/**
 * Created by agufed on 10/21/17.
 */
public class BaseActionBean<T>{
    private Gson gson;

    //Getters & Setters
    public String getJsonString(T o) {
        if(gson == null)
            gson = new Gson();
        return gson.toJson(o);
    }

}
