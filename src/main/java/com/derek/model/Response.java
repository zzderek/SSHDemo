package com.derek.model;

import lombok.Data;

@Data
public class Response {

    private String returnMessage;
    private String returnCode;
    private Object data;
}
