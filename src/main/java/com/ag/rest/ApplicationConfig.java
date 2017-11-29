/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ag.rest;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author agunga
 */
@javax.ws.rs.ApplicationPath("wr")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(TicketREST.class);
        resources.add(EventREST.class);
        resources.add(VenueREST.class);
        resources.add(com.ag.rest.PaymentREST.class);
        resources.add(LocationREST.class);
        resources.add(com.ag.rest.UserREST.class);
    }

}
