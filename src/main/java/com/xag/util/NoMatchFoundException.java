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
public class NoMatchFoundException extends Exception {

    public NoMatchFoundException() {
        super();
    }

    public NoMatchFoundException(String message) {
        super(message);
    }

    public NoMatchFoundException(Throwable cause) {
        super(cause);
    }

    public NoMatchFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
