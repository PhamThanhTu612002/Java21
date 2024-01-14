package vn.techmaster.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Actor;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
