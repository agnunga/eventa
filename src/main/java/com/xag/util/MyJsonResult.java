package com.xag.util;

import java.util.List;

/**
 * Created by agufed on 10/20/17.
 */
public class MyJsonResult<T> {
    private String message;
    private List<T> rows;

    public MyJsonResult(String message, List<T> rows) {
        this.message = message;
        this.rows = rows;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
