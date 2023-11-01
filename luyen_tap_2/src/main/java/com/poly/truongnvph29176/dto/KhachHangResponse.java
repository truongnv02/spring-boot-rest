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
public class KhachHangResponse {
    private Long ma;

    private String ten;

    private String sdt;

    private Integer gioiTinh;

    private Integer maHang;

    private String tenHang;
}
