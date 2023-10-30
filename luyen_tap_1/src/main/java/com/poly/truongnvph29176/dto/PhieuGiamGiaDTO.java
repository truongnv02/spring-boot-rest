package com.poly.truongnvph29176.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class PhieuGiamGiaDTO {
    @NotBlank(message = "Mã không được để trống")
    private String ma;

    @NotBlank(message = "Tên không được để trống")
    private String ten;

    @NotBlank(message = "Giá trị giảm không được để trống")
    private String giaTriGiam;

    @NotNull(message = "Hình thức giảm không được để trống")
    private Integer hinhThucGiam;

    @NotNull(message = "ID Khách Hàng không được để trống")
    private Long idKhachHang;
}
