package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.dto.KhachHangResponse;
import com.poly.truongnvph29176.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
    @Query("select new com.poly.truongnvph29176.dto.KhachHangResponse(kh.ma, kh.ten, kh.sdt,kh.gioiTinh, kh.hangKhachHang.ma, kh.hangKhachHang.ten) from KhachHang kh")
    List<KhachHangResponse> findAllNoPage();
}
