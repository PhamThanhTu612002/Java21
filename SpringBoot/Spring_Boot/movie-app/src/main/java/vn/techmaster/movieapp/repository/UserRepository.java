package vn.techmaster.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.User;
import vn.techmaster.movieapp.model.Role;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    List<User> findByRole(Role role);
}
