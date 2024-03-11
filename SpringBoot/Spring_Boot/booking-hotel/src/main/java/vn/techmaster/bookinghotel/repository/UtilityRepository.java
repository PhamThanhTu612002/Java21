package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Utility;

@Repository
public interface UtilityRepository extends JpaRepository<Utility,Integer> {
}
