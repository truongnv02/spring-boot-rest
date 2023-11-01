package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.entity.HangKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HangKhachHangRepository extends JpaRepository<HangKhachHang, Integer> {
}
