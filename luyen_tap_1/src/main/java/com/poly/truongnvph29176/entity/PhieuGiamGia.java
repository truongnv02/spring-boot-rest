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
@Table(name = "PhieuGiamGia")
public class PhieuGiamGia implements Serializable {
    @Id
    @Column(name = "MaPhieu")
    private String ma;

    @Column(name = "TenPhieu")
    private String ten;

    @Column(name = "GiaTriGiam")
    private String giaTriGiam;

    @Column(name = "HinhThucGiam")
    private Integer hinhThucGiam;

    @ManyToOne
    @JoinColumn(name = "NguoiSoHuu", referencedColumnName = "MaKhachHang")
    private KhachHang khachHang;
}
