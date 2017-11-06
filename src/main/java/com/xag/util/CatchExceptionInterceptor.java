/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.xag.util;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author agunga
 */
@CatchMyException
@Interceptor
public class CatchExceptionInterceptor {

    private final Logger log = LoggerFactory.getLogger(Object.class);

    @AroundInvoke
    private Object intercept(InvocationContext ic) throws Exception {
        try {
            return ic.proceed();
        } catch (Exception e) {
            e.getMessage();
            log.error("Exception");
            return null;
        }
    }
}
