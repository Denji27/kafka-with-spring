package com.example.model;

import lombok.Data;

@Data
public class Message {
    private String to;
    private String toName;
    private String subject;
    private String content;
}
