package com.fontysxmaua.UniGuide.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@AllArgsConstructor
public class NotificationResponse {
    private final String id;
    private final String sender;
    private final String subject;
    private final String message;
    private final Date dateCreated;
}
