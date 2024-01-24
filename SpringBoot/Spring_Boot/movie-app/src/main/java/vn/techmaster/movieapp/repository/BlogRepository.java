package vn.techmaster.movieapp.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.movieapp.entity.Blog;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog,Integer> {
    List<Blog> findTop4ByStatusOrderByPublishedAtDesc(boolean status);
    Page<Blog> findByStatusOrderByPublishedAtDesc(boolean status , Pageable pageable);
    Blog findByIdAndSlugAndStatus(Integer id, String slug, boolean status);

    Page<Blog> findAllByOrderByCreatedAtDesc(Pageable pageable);
    Blog findBlogById(Integer id);
}
