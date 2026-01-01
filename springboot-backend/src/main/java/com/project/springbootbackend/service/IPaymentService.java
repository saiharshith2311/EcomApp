package com.project.springbootbackend.service;

import com.project.springbootbackend.dto.PaymentIntentRequestDto;
import com.project.springbootbackend.dto.PaymentIntentResponseDto;

public interface IPaymentService {
    PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto paymentIntentRequestDto);
}
