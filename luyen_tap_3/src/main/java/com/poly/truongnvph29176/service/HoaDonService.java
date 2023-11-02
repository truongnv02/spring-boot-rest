package com.poly.truongnvph29176.service;

import com.poly.truongnvph29176.dto.HoaDonRequest;
import com.poly.truongnvph29176.dto.HoaDonResponse;
import com.poly.truongnvph29176.entity.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface HoaDonService {
    List<HoaDonResponse> listHoaDon();
    Page<HoaDonResponse> listHoaDonPages(Pageable pageable);
    HoaDon update(Long id, HoaDonRequest hoaDonRequest);
    String delete(Long id);
    List<HoaDonResponse> filter();
    Optional<HoaDonResponse> max();
}
