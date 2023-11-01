package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.KhachHangDTO;
import com.poly.truongnvph29176.dto.KhachHangResponse;
import com.poly.truongnvph29176.entity.KhachHang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface KhachHangService {
    List<KhachHangResponse> findAll();
    Page<KhachHangResponse> findAllPages(Pageable pageable);
    KhachHang create(KhachHangDTO khachHangDTO) throws Exception;
    KhachHang findByMa(Long ma) throws Exception;
    KhachHang update(Long ma, KhachHangDTO khachHangDTO) throws Exception;
    void delete(Long id);
}
