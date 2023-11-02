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
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString
@Entity
@Table(name = "PhieuGiaoHang")
public class PhieuGiaoHang implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "MaPhieuGiao")
    private UUID id;

    @Column(name = "SdtNhan")
    private String sdtNguoiNhan;

    @Column(name = "PhiGiaoHang")
    private Double phiGiao;

    @ManyToOne
    @JoinColumn(name = "HoaDonGiao")
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "DiaChiGiao")
    private DiaChi diaChi;
}
