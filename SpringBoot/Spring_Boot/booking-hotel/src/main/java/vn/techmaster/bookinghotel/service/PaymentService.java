package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Payment;
import vn.techmaster.bookinghotel.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;
    public List<Payment> getPaymentByUserId(Integer userId){
        return paymentRepository.findByUser_Id(userId);
    }

    public boolean existsPaymentByBooking_IdAndStatus(Integer bookingId, Boolean status){
        return paymentRepository.existsPaymentByBooking_IdAndStatus(bookingId,status);
    }
}
