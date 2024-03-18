package vn.techmaster.bookinghotel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.bookinghotel.entity.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findByStatus(boolean status);
    List<Blog> findTop5ByStatusOrderByCreatedAtDesc(boolean status);

    Page<Blog> findByStatus(boolean status, Pageable pageable);
    Blog findByIdAndSlug(Integer id, String slug);
}
