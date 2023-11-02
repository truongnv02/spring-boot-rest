package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.entity.HoaDon;
import com.poly.truongnvph29176.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Long> {
    HoaDon findByKhachHang(KhachHang idKhachHang);
}
