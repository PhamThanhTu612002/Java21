package vn.techmaster.bookinghotel.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import vn.techmaster.bookinghotel.entity.Booking;
import vn.techmaster.bookinghotel.entity.Hotel;
import vn.techmaster.bookinghotel.entity.HotelRoom;
import vn.techmaster.bookinghotel.exception.ResourceNotFoundException;
import vn.techmaster.bookinghotel.repository.BookingRepository;
import vn.techmaster.bookinghotel.repository.HotelRoomRepository;

import java.time.LocalDate;
import java.util.*;


@Service
public class BookingService {
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    HotelRoomRepository hotelRoomRepository;

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
    public Integer bookingMonth(Integer userId){
        LocalDate date = LocalDate.now();
        return bookingRepository.countBookingByBookingMonth(date.getMonthValue(),userId);
    }

    public Integer pendingBooking(Integer status,Integer userID){
        return bookingRepository.countBookingByStatusAndUser_Id(status,userID);
    }

    public List<Booking> getBookingOrderByBookingDateDesc(){
        return bookingRepository.findAll().stream().sorted(Comparator.comparing(Booking::getBookingDate).reversed()).toList();
    }
    public Page<Booking> findBookingsByManagerId(Integer useId,Integer page, Integer size){
        return bookingRepository.findBookingsByManagerId(useId, PageRequest.of(page-1,size));
    }
    @Transactional
    public void deleteBooking(Integer bookingID){
        Booking booking = bookingRepository.findById(bookingID).orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy booking"));

        bookingRepository.delete(booking);
    }
    public List<Object[]> getMonthlyTotalPriceForYear(Integer year,Integer userId) {
        return bookingRepository.getMonthlyTotalPriceForYear(year,userId);
    }
    public List<Booking> getBookingToReview(Integer userId, Integer hotelId){
        return bookingRepository.getBookingToReview(userId,hotelId);
    }

    public Boolean checkToBooking(Integer hotelId, Integer roomId, String checkInDate){
        List<Booking> bookings = bookingRepository.checkToBooking(hotelId,roomId,checkInDate);

        HotelRoom hotelRoom = hotelRoomRepository.findHotelRoomByHotel_IdAndRoom_Id(hotelId,roomId);
        if (bookings.size() == hotelRoom.getQuantity()){
            return false;
        }else {
            return true;
        }
    }

}
