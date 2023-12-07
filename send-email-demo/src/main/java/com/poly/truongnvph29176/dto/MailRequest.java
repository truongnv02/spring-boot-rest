package com.poly.truongnvph29176.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MailRequest {
    private String to;
    private String from;
    private String name;
    private String subject;
}
