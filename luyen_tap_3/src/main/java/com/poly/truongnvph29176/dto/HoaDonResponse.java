package com.poly.truongnvph29176.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HoaDonResponse {
    private Long maHoaDon;

    private String nguoiLap;

    private String sdtNguoiNhan;

    private Double phiGiao;

    private String diaChiGiao;
}
