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
public class OrderDetail {
    private String name;
    private Long price;
    private Integer quantity;
    private Long sub_total;
}
