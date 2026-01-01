package com.project.springbootbackend.controller;

import com.project.springbootbackend.dto.PaymentIntentRequestDto;
import com.project.springbootbackend.dto.PaymentIntentResponseDto;
import com.project.springbootbackend.service.IPaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {
    private final IPaymentService iPaymentService;

    @PostMapping("/create-payment-intent")
    public ResponseEntity<PaymentIntentResponseDto> createPaymentIntent(
            @RequestBody PaymentIntentRequestDto paymentRequestDto) {
        PaymentIntentResponseDto response = iPaymentService.createPaymentIntent(paymentRequestDto);
        return ResponseEntity.ok(response);
    }

}
