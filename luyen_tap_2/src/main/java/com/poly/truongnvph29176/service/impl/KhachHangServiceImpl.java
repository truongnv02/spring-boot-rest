package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.dto.KhachHangDTO;
import com.poly.truongnvph29176.dto.KhachHangResponse;
import com.poly.truongnvph29176.entity.HangKhachHang;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.exception.DataNotFondException;
import com.poly.truongnvph29176.repository.HangKhachHangRepository;
import com.poly.truongnvph29176.repository.KhachHangRepository;
import com.poly.truongnvph29176.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhachHangServiceImpl implements KhachHangService {
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private HangKhachHangRepository hangKhachHangRepository;

    @Override
    public List<KhachHangResponse> findAll() {
        return khachHangRepository.findAllNoPage();
    }

    @Override
    public Page<KhachHangResponse> findAllPages(Pageable pageable) {
        return khachHangRepository.findAll(pageable).map(khachHang ->
            KhachHangResponse.builder()
                    .ma(khachHang.getMa())
                    .ten(khachHang.getTen())
                    .sdt(khachHang.getSdt())
                    .gioiTinh(khachHang.getGioiTinh())
                    .maHang(khachHang.getHangKhachHang().getMa())
                    .tenHang(khachHang.getHangKhachHang().getTen())
                    .build()
        );
    }

    @Override
    public KhachHang create(KhachHangDTO khachHangDTO) throws Exception {
        HangKhachHang idHangKhachHang = hangKhachHangRepository
                .findById(khachHangDTO.getIdHangKhachHang()).orElseThrow(() ->
                            new DataNotFondException("Cannot find Hang Khach Hang with id = "
                                    + khachHangDTO.getIdHangKhachHang())
                        );
        KhachHang khachHang = KhachHang.builder()
                .ten(khachHangDTO.getTen())
                .sdt(khachHangDTO.getSdt())
                .gioiTinh(khachHangDTO.getGioiTinh())
                .hangKhachHang(idHangKhachHang)
                .build();
        return khachHangRepository.save(khachHang);
    }

    @Override
    public KhachHang findByMa(Long ma) throws Exception {
        return khachHangRepository.findById(ma).orElseThrow(() ->
                    new DataNotFondException("Cannot find Khach Hang with ma = " + ma)
                );
    }

    @Override
    public KhachHang update(Long ma, KhachHangDTO khachHangDTO) throws Exception {
        KhachHang idKhachHang = findByMa(ma);
        if(idKhachHang != null) {
            HangKhachHang idHangKhachHang = hangKhachHangRepository
                    .findById(khachHangDTO.getIdHangKhachHang()).orElseThrow(() ->
                            new DataNotFondException("Cannot find Hang Khach Hang with id = "
                                    + khachHangDTO.getIdHangKhachHang())
                    );
            idKhachHang.setTen(khachHangDTO.getTen());
            idKhachHang.setSdt(khachHangDTO.getSdt());
            idKhachHang.setGioiTinh(khachHangDTO.getGioiTinh());
            idKhachHang.setHangKhachHang(idHangKhachHang);
            return khachHangRepository.save(idKhachHang);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        khachHangRepository.deleteById(id);
    }
}
