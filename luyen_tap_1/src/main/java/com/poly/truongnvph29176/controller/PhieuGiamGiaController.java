package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.PhieuGiamGiaDTO;
import com.poly.truongnvph29176.entity.PhieuGiamGia;
import com.poly.truongnvph29176.service.PhieuGiamGiaService;
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
@RequestMapping("/phieu-giam-gia")
public class PhieuGiamGiaController {
    @Autowired
    private PhieuGiamGiaService phieuGiamGiaService;

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PhieuGiamGia> listPhieuGiamGia = phieuGiamGiaService.findAll();
        return ResponseEntity.ok(listPhieuGiamGia);
    }

    @GetMapping("")
    public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0", name = "page") Integer number) {
        Pageable pageable = PageRequest.of(number, 5);
        Page<PhieuGiamGia> listPhieuGiamGia = phieuGiamGiaService.findAllPages(pageable);
        return ResponseEntity.ok(listPhieuGiamGia);
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@Valid @RequestBody PhieuGiamGiaDTO phieuGiamGiaDTO, BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }else {
                PhieuGiamGia phieuGiamGia = phieuGiamGiaService.create(phieuGiamGiaDTO);
                return ResponseEntity.ok(phieuGiamGia);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/update/{ma}")
    public ResponseEntity<?> update(@PathVariable("ma") String ma,
                                    @Valid @RequestBody PhieuGiamGiaDTO phieuGiamGiaDTO,
                                    BindingResult result) {
        try {
            if(result.hasErrors()) {
                List<String> errorMessage = result.getFieldErrors()
                        .stream()
                        .map(FieldError::getDefaultMessage)
                        .toList();
                return ResponseEntity.badRequest().body(errorMessage);
            }else {
                PhieuGiamGia phieuGiamGia = phieuGiamGiaService.update(ma, phieuGiamGiaDTO);
                return ResponseEntity.ok(phieuGiamGia);
            }
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("/{ma}")
    public ResponseEntity<?> delete(@PathVariable("ma") String ma) {
        phieuGiamGiaService.delete(ma);
        return ResponseEntity.ok("Deleted with id = " + ma + " successfully");
    }
}
