package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.KhachHangDTO;
import com.poly.truongnvph29176.dto.KhachHangResponse;
import com.poly.truongnvph29176.entity.KhachHang;
import com.poly.truongnvph29176.service.KhachHangService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/khach-hang")
public class KhachHangController {
    @Autowired
    private KhachHangService khachHangService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<KhachHangResponse> khachHangs = khachHangService.findAll();
        return ResponseEntity.ok(khachHangs);
    }

    @GetMapping("/findAllPages")
    public ResponseEntity<?> findAllPages(@RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<KhachHangResponse> khachHangs = khachHangService.findAllPages(pageable);
        return ResponseEntity.ok(khachHangs);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody KhachHangDTO khachHangDTO, BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result
                        .getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }else {
                KhachHang khachHang = khachHangService.create(khachHangDTO);
                return ResponseEntity.ok(khachHang);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@PathVariable("ma") Long ma,
                                    @Valid @RequestBody KhachHangDTO khachHangDTO,
                                    BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result
                        .getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }else {
                KhachHang khachHang = khachHangService.update(ma, khachHangDTO);
                return ResponseEntity.ok(khachHang);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/delete/{ma}")
    public ResponseEntity<?> delete(@PathVariable("ma") Long ma) {
        try {
            khachHangService.delete(ma);
            return ResponseEntity.ok("Deleted with ma = " + ma + " successfully");
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
