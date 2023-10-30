package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.dto.PhieuGiamGiaDTO;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.entity.PhieuGiamGia;
import com.poly.truongnvph29176.exception.DataNotFoundException;
import com.poly.truongnvph29176.repository.KhachHangRepository;
import com.poly.truongnvph29176.repository.PhieuGiamGiaRepository;
import com.poly.truongnvph29176.service.PhieuGiamGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhieuGiamGiaServiceImpl implements PhieuGiamGiaService {
    @Autowired
    private PhieuGiamGiaRepository phieuGiamGiaRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;

    @Override
    public List<PhieuGiamGia> findAll() {
        return phieuGiamGiaRepository.findAll();
    }

    @Override
    public Page<PhieuGiamGia> findAllPages(Pageable pageable) {
        return phieuGiamGiaRepository.findAll(pageable);
    }

    @Override
    public PhieuGiamGia create(PhieuGiamGiaDTO phieuGiamGiaDTO) throws Exception {
        KhachHang idKhachHang = khachHangRepository.findById(phieuGiamGiaDTO.getIdKhachHang()).orElseThrow(() ->
                    new DataNotFoundException("Cannot find Khách Hàng with id = " + phieuGiamGiaDTO.getIdKhachHang())
                );
        PhieuGiamGia phieuGiamGia = PhieuGiamGia.builder()
                .ma(phieuGiamGiaDTO.getMa())
                .ten(phieuGiamGiaDTO.getTen())
                .giaTriGiam(phieuGiamGiaDTO.getGiaTriGiam())
                .hinhThucGiam(phieuGiamGiaDTO.getHinhThucGiam())
                .khachHang(idKhachHang)
                .build();
        return phieuGiamGiaRepository.save(phieuGiamGia);
    }

    @Override
    public PhieuGiamGia update(String ma, PhieuGiamGiaDTO phieuGiamGiaDTO) throws Exception {
        PhieuGiamGia phieuGiamGia = phieuGiamGiaRepository.findById(ma).orElseThrow(() ->
                new DataNotFoundException("Cannot find Phiếu Giảm Giá with id = " + ma)
        );
        if(phieuGiamGia != null) {
            KhachHang idKhachHang = khachHangRepository.findById(phieuGiamGiaDTO.getIdKhachHang()).orElseThrow(() ->
                    new DataNotFoundException("Cannot find Khách Hàng with id = " + phieuGiamGiaDTO.getIdKhachHang())
            );
                    phieuGiamGia.setMa(phieuGiamGiaDTO.getMa());
                    phieuGiamGia.setTen(phieuGiamGiaDTO.getTen());
                    phieuGiamGia.setGiaTriGiam(phieuGiamGiaDTO.getGiaTriGiam());
                    phieuGiamGia.setHinhThucGiam(phieuGiamGiaDTO.getHinhThucGiam());
                    phieuGiamGia.setKhachHang(idKhachHang);
            return phieuGiamGiaRepository.save(phieuGiamGia);
        }
        return null;
    }

    @Override
    public void delete(String ma) {
        phieuGiamGiaRepository.deleteById(ma);
    }
}
