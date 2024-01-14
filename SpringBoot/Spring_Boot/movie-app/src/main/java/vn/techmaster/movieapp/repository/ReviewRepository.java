package vn.techmaster.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
