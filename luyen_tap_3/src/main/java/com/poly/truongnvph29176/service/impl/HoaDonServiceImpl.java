package com.poly.truongnvph29176.service.impl;

import com.poly.truongnvph29176.dto.HoaDonRequest;
import com.poly.truongnvph29176.dto.HoaDonResponse;
import com.poly.truongnvph29176.entity.HoaDon;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.repository.HoaDonRepository;
import com.poly.truongnvph29176.repository.KhachHangRepository;
import com.poly.truongnvph29176.repository.PhieuGiaoHangRepository;
import com.poly.truongnvph29176.service.HoaDonService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HoaDonServiceImpl implements HoaDonService {
    private final PhieuGiaoHangRepository phieuGiaoHangRepository;
    private final HoaDonRepository hoaDonRepository;
    private final KhachHangRepository khachHangRepository;

    @Override
    public List<HoaDonResponse> listHoaDon() {
        return phieuGiaoHangRepository.listHoaDon();
    }

    @Override
    public Page<HoaDonResponse> listHoaDonPages(Pageable pageable) {
        return phieuGiaoHangRepository.findAll(pageable).map(phieuGiaoHang ->
                    HoaDonResponse.builder()
                            .maHoaDon(phieuGiaoHang.getHoaDon().getMa())
                            .nguoiLap(phieuGiaoHang.getHoaDon().getNguoiLap())
                            .sdtNguoiNhan(phieuGiaoHang.getSdtNguoiNhan())
                            .phiGiao(phieuGiaoHang.getPhiGiao())
                            .diaChiGiao(phieuGiaoHang.getDiaChi().getTenDiaChi())
                            .build()
                );
    }

    @Override
    public HoaDon update(Long id, HoaDonRequest hoaDonRequest) {
        HoaDon idHoaDon = hoaDonRepository.findById(id).orElse(null);
        if(idHoaDon != null) {
            KhachHang idKhachHang = khachHangRepository.findById(hoaDonRequest.getNguoiMua()).orElse(null);
            idHoaDon.setNguoiLap(hoaDonRequest.getNguoiLap());
            idHoaDon.setNgayLap(hoaDonRequest.getNgayLap());
            idHoaDon.setGhiChu(hoaDonRequest.getGhiChu());
            idHoaDon.setNgayThanhToan(hoaDonRequest.getNgayThanhToan());
            idHoaDon.setTrangThai(hoaDonRequest.getTrangThai());
            idHoaDon.setKhachHang(idKhachHang);
            return hoaDonRepository.save(idHoaDon);
        }
        return null;
    }

    @Override
    public String delete(Long id) {
        KhachHang idKhachHang = khachHangRepository.findById(id).orElse(null);
        if(idKhachHang != null) {
            HoaDon hoaDon = hoaDonRepository.findByKhachHang(idKhachHang);
            if(hoaDon != null) {
                hoaDonRepository.delete(hoaDon);
                return "Hóa đơn đã được xóa thành công";
            }else {
                return "Không tìm thấy hóa đơn cho khách hàng này";
            }
        }else {
            return "Không tìm thấy khách hàng với ID này";
        }
    }

    @Override
    public List<HoaDonResponse> filter() {
        List<HoaDonResponse> list = phieuGiaoHangRepository.listHoaDon();
        return list.stream().filter(hoaDonResponse ->
                hoaDonResponse.getPhiGiao().intValue() > 1000 &&
                        hoaDonResponse.getPhiGiao().intValue() < 3000)
                .toList();
    }

    @Override
    public Optional<HoaDonResponse> max() {
        List<HoaDonResponse> list = phieuGiaoHangRepository.listHoaDon();
        return list.stream()
                .max(Comparator.comparingDouble(HoaDonResponse::getPhiGiao));
    }
}
