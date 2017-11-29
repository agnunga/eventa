/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import com.xag.util.RestUtil;
import com.ag.beanI.EventBeanI;
import com.ag.beanI.VenueBeanI;
import com.ag.model.Event;
import com.xag.util.ResponseObject;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author agunga
 */
@Path("/event")
public class EventREST {

    @EJB
    EventBeanI beanI;
    @EJB
    VenueBeanI rtbi;

    private ResponseObject responseObject = null;

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Event entity) {
        Event addedEvent = beanI.add(entity);
        responseObject = (addedEvent != null) ? RestUtil.setResponseObject(true, addedEvent) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @PUT
    @Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Event entity) {
        Event updatedEvent = beanI.update(entity);
        responseObject = (updatedEvent != null) ? RestUtil.setResponseObject(true, updatedEvent) : RestUtil.setResponseObject(false, entity);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @DELETE
    @Path("/remove/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") long id) {
        int deletedRows = beanI.delete(id);
        responseObject = (deletedRows > 0) ? RestUtil.setResponseObject(true, deletedRows) : RestUtil.setResponseObject(false, deletedRows);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @DELETE
    @Path("/remove")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(Event entity) {
        boolean isDeleted = beanI.delete(entity);
        responseObject = (isDeleted) ? RestUtil.setResponseObject(true, isDeleted) : RestUtil.setResponseObject(false, isDeleted);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/find/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response find(@PathParam("id") long id) {
        Event fetchedEvent = beanI.findById(id);
        responseObject = (fetchedEvent != null) ? RestUtil.setResponseObject(true, fetchedEvent) : RestUtil.setResponseObject(false, null);
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

    @GET
    @Path("/findAll")
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        responseObject = RestUtil.setResponseObject(true, beanI.findAll());
        return Response.status(Response.Status.OK).entity(responseObject).build();
    }

}
