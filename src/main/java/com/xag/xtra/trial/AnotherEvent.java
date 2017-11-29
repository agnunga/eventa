/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.xtra.trial;

import javax.inject.Named;

/**
 *
 * @author agunga
 */
@Named("myAnotherEvent")
public class AnotherEvent implements EventResource {

    @Override
    public String takeAction() {
        return "At takeAction()";
    }

}
