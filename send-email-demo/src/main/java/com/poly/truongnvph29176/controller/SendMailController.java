package com.poly.truongnvph29176.controller;

import com.poly.truongnvph29176.dto.MailRequest;
import com.poly.truongnvph29176.dto.MailResponse;
import com.poly.truongnvph29176.dto.OrderDetail;
import com.poly.truongnvph29176.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/send-email")
public class SendMailController {
    private final EmailService emailService;

    @PostMapping("")
    public MailResponse sendMail(@RequestBody MailRequest request) {
        List<OrderDetail> orders = new ArrayList<>();
        orders.add(new OrderDetail("Sản phẩm 1", 100000L, 1, 100000L));
        orders.add(new OrderDetail("Sản phẩm 2", 50000L, 1, 50000L));
        orders.add(new OrderDetail("Sản phẩm 3", 50000L, 2, 100000L));
        Long total = 0L;
        Long ship_fee = 15000L;
        for(OrderDetail item : orders) {
            total += item.getPrice() * item.getQuantity();
        }

        Map<String, Object> model = new HashMap<>();
        model.put("name", request.getName());
        model.put("mail",request.getTo());
        model.put("location", "Dương Quảng Hàm, Quan Hoa, Cầu Giấy, Hà Nội");
        model.put("orders", orders);
        model.put("ship_fee", ship_fee);
        model.put("total", total + ship_fee);
        model.put("total_noship", total);

        return emailService.sendEmail(request, model);
    }
}
