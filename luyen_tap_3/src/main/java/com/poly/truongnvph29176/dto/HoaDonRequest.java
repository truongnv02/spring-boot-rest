package com.poly.truongnvph29176.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class HoaDonRequest {
    private LocalDate ngayLap;
    private String nguoiLap;
    private String ghiChu;
    private LocalDate ngayThanhToan;
    private Integer trangThai;
    private Long nguoiMua;
}
