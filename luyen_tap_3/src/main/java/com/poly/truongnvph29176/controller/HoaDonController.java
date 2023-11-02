package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.HoaDonRequest;
import com.poly.truongnvph29176.dto.HoaDonResponse;
import com.poly.truongnvph29176.entity.HoaDon;
import com.poly.truongnvph29176.service.HoaDonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/hoa-don")
@RequiredArgsConstructor
public class HoaDonController {
    private final HoaDonService hoaDonService;

    @GetMapping("")
    public ResponseEntity<?> listHoaDon() {
        List<HoaDonResponse> listHoaDon= hoaDonService.listHoaDon();
        return ResponseEntity.ok(listHoaDon);
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> listHoaDonPages(@RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<HoaDonResponse> listHoaDonPages = hoaDonService.listHoaDonPages(pageable);
        return ResponseEntity.ok(listHoaDonPages);
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@PathVariable("ma") Long ma,
                                    @Valid @RequestBody HoaDonRequest hoaDonRequest,
                                    BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }else {
                HoaDon hoaDon = hoaDonService.update(ma, hoaDonRequest);
                return ResponseEntity.ok(hoaDon);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable("ma") Long id) {
        String result = hoaDonService.delete(id);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/filter")
    public ResponseEntity<?> filter() {
        List<HoaDonResponse> list = hoaDonService.filter();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/max")
    public ResponseEntity<?> max() {
        Optional<HoaDonResponse> list = hoaDonService.max();
        return ResponseEntity.ok(list);
    }
}
