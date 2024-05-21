package vn.techmaster.bookinghotel.repository.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.repository.BookingRepositoryCustom;

import java.util.List;

@Repository
public class BookingRepositoryCustomImpl implements BookingRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Object[]> getMonthlyTotalPriceForYear(Integer year,Integer managerID) {
        String sql = "SELECT " +
                "SUM(CASE WHEN MONTH(booking_date) = 1 THEN total_price ELSE 0 END) AS thang_1, " +
                "SUM(CASE WHEN MONTH(booking_date) = 2 THEN total_price ELSE 0 END) AS thang_2, " +
                "SUM(CASE WHEN MONTH(booking_date) = 3 THEN total_price ELSE 0 END) AS thang_3, " +
                "SUM(CASE WHEN MONTH(booking_date) = 4 THEN total_price ELSE 0 END) AS thang_4, " +
                "SUM(CASE WHEN MONTH(booking_date) = 5 THEN total_price ELSE 0 END) AS thang_5, " +
                "SUM(CASE WHEN MONTH(booking_date) = 6 THEN total_price ELSE 0 END) AS thang_6, " +
                "SUM(CASE WHEN MONTH(booking_date) = 7 THEN total_price ELSE 0 END) AS thang_7, " +
                "SUM(CASE WHEN MONTH(booking_date) = 8 THEN total_price ELSE 0 END) AS thang_8, " +
                "SUM(CASE WHEN MONTH(booking_date) = 9 THEN total_price ELSE 0 END) AS thang_9, " +
                "SUM(CASE WHEN MONTH(booking_date) = 10 THEN total_price ELSE 0 END) AS thang_10, " +
                "SUM(CASE WHEN MONTH(booking_date) = 11 THEN total_price ELSE 0 END) AS thang_11, " +
                "SUM(CASE WHEN MONTH(booking_date) = 12 THEN total_price ELSE 0 END) AS thang_12 " +
                "FROM bookings " +
                "WHERE YEAR(booking_date) = "+year+" AND status = 2 AND user_id = "+managerID;

        Query query = entityManager.createNativeQuery(sql);
        return query.getResultList();
    }
}
