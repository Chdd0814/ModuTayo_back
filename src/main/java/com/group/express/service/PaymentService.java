package com.group.express.service;

import com.group.express.domain.BusBooking;
import com.group.express.domain.Payment;
import com.group.express.repository.BusBookingRepository;
import com.group.express.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;
    @Autowired
    public PaymentService(PaymentRepository paymentRepository){this.paymentRepository=paymentRepository;}

    public List<Payment> getPaymentList(String id ){
        return paymentRepository.findPaymentsById(id);
    }
    public void PaymentSuccess(Payment payment) {
        // 결제 정보를 데이터베이스에 저장
        try {
            paymentRepository.save(payment);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
