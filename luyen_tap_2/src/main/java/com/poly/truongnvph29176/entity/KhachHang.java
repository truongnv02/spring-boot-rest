package com.poly.truongnvph29176.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "KhachHang")
public class KhachHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MaKhachHang")
    private Long ma;

    @Column(name = "TenKhachHang")
    private String ten;

    @Column(name = "SoDienThoai")
    private String sdt;

    @Column(name = "GioiTinh")
    private Integer gioiTinh;

    @ManyToOne
    @JoinColumn(name = "HangKhachHang", referencedColumnName = "MaHang")
    private HangKhachHang hangKhachHang;
}
