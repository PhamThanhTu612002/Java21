package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Utility;
import vn.techmaster.bookinghotel.model.UtilityType;

import java.util.List;

@Repository
public interface UtilityRepository extends JpaRepository<Utility,Integer> {
    List<Utility> findByUtilityType(UtilityType utilityType);
}
