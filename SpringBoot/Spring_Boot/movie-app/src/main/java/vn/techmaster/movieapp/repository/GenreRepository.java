package vn.techmaster.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre,Integer> {
}
