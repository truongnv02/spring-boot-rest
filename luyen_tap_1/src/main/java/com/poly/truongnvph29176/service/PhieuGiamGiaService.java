package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.PhieuGiamGiaDTO;
import com.poly.truongnvph29176.entity.PhieuGiamGia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhieuGiamGiaService {
    List<PhieuGiamGia> findAll();
    Page<PhieuGiamGia> findAllPages(Pageable pageable);
    PhieuGiamGia create(PhieuGiamGiaDTO phieuGiamGiaDTO) throws Exception;
    PhieuGiamGia update(String ma, PhieuGiamGiaDTO phieuGiamGiaDTO)  throws Exception;
    void delete(String ma);
}
