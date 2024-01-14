package vn.techmaster.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director,Integer> {
}
