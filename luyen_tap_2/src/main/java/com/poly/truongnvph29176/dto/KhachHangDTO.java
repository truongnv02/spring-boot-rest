package com.poly.truongnvph29176.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class KhachHangDTO {
    @NotBlank(message = "Không được để trống")
    private String ten;

    @NotBlank(message = "Không được để trống")
    private String sdt;

    private Integer gioiTinh;

    @NotNull(message = "Không được để trống")
    private Integer idHangKhachHang;
}
