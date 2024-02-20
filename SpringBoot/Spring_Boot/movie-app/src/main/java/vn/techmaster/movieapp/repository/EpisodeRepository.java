package vn.techmaster.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Episode;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,Integer> {
    List<Episode> findByMovie_IdOrderByDisplayOrderAsc(Integer movieId);
    List<Episode> findByMovie_IdAndStatusOrderByDisplayOrderAsc(Integer movieId,Boolean status);

    Episode findByMovie_IdAndDisplayOrderAndStatus(Integer movieId, int i, boolean status);
}
