package vn.techmaster.bookinghotel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
}
