package vn.techmaster.bookinghotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Booking;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.repository.BookingRepository;

import java.time.LocalDate;
import java.util.*;


@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;

    public List<Booking> getBookingByUserId(Integer userId){
        return bookingRepository.findByUser_Id(userId);
    }

    public Map<Booking, HotelRoom> getBookingHotelRoom(List<Booking> bookings){
        Map<Booking, HotelRoom> bookingHotelMap = new HashMap<>();
        for (Booking booking : bookings){
            bookingHotelMap.put(booking,booking.getHotel_room());
        }
        return bookingHotelMap;
    }
    public Integer bookingToday(Integer userId){
        LocalDate date = LocalDate.now();
        return bookingRepository.countBookingByBookingDate(date.getDayOfMonth(),userId);
    }

    public Integer pendingBooking(boolean status,Integer userID){
        return bookingRepository.countBookingByStatusAndUser_Id(status,userID);
    }

    public List<Booking> getBookingOrderByBookingDateDesc(){
        return bookingRepository.findAll().stream().sorted(Comparator.comparing(Booking::getBookingDate).reversed()).toList();
    }
     public Page<Booking> findBookingsByManagerId(Integer useId,Integer page, Integer size){
        return bookingRepository.findBookingsByManagerId(useId, PageRequest.of(page-1,size));
     }
}
