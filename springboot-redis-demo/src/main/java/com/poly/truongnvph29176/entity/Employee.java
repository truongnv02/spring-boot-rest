package com.poly.truongnvph29176.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Employee implements Serializable {
    private Long id;

    private String firstName;

    private String lastName;

    private String emailId;
}
