package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.repository.BookingRepository;

@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
}
