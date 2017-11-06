/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.util;

/**
 *
 * @author agunga
 */
public class EventaException extends Exception {

    public EventaException() {
        super();
    }

    public EventaException(String message) {
        super(message);
    }

    public EventaException(Throwable cause) {
        super(cause);
    }

    public EventaException(String message, Throwable cause) {
        super(message, cause);
    }

}
