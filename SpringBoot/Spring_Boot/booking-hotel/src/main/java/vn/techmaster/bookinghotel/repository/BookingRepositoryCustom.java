package vn.techmaster.bookinghotel.repository;

import java.util.List;

public interface BookingRepositoryCustom {
    List<Object[]> getMonthlyTotalPriceForYear(Integer year,Integer managerId);
}
