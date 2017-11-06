/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.xtra.trial;

import javax.annotation.Resource;

/**
 *
 * @author agunga
 */
@Resource(name = "myEventResource")
public interface EventResource {

    public String takeAction();
}
