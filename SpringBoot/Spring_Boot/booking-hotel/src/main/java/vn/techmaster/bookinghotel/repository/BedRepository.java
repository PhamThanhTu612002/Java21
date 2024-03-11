package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Bed;

@Repository
public interface BedRepository extends JpaRepository<Bed, Integer> {
}
