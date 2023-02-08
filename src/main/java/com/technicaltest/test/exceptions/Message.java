package com.technicaltest.test.exceptions;

import lombok.Data;

@Data
public class Message {

    private String message;

    public Message(String message) {
        this.message = message;
    }
}
