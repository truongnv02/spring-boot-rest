package com.poly.truongnvph29176.repository;

import com.poly.truongnvph29176.dto.HoaDonResponse;
import com.poly.truongnvph29176.entity.PhieuGiaoHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PhieuGiaoHangRepository extends JpaRepository<PhieuGiaoHang, UUID> {
    @Query("""
            select new com.poly.truongnvph29176.dto.HoaDonResponse
            (pgh.hoaDon.ma, pgh.hoaDon.nguoiLap, pgh.sdtNguoiNhan, pgh.phiGiao, pgh.diaChi.tenDiaChi)
             from PhieuGiaoHang pgh
            """)
    List<HoaDonResponse> listHoaDon();
}
