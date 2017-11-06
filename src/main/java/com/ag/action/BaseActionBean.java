package com.ag.action;

import com.ag.model.Admin;
import com.ag.model.Audience;
import com.google.gson.Gson;
import com.xag.util.MyJsonResult;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;

/**
 * Created by agufed on 10/21/17.
 */
public class BaseActionBean<T> implements ActionBean {
    private ActionBeanContext context;
    private Gson gson;

    @Override
    public void setContext(ActionBeanContext actionBeanContext) {
        this.context = actionBeanContext;
    }

    @Override
    public ActionBeanContext getContext() {
        return context;
    }

    public Resolution sendResponse(final String res, String resptype){
        return new StreamingResolution(resptype, res);
    }

    //Getters & Setters
    public String getJsonString(T o) {
        if(gson == null)
            gson = new Gson();
        return gson.toJson(o);
    }

    public Admin getAdmin() {
        return (Admin)getContext().getRequest().getSession().getAttribute("admin");
    }

    public Audience getAudience() {
        return (Audience)getContext().getRequest().getSession().getAttribute("audience");
    }

}
