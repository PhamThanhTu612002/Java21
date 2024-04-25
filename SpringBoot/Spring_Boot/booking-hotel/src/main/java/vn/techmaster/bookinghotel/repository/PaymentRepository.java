package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Payment;
import vn.techmaster.bookinghotel.entity.Room;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {
    List<Payment> findByUser_Id(Integer userId);
    Boolean existsPaymentByBooking_IdAndStatus(Integer booking_id, Boolean status);
}
