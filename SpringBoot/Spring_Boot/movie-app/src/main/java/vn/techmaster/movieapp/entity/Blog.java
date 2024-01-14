package vn.techmaster.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "blogs")
@ToString
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tự động tăng
    Integer id;
    String title;

    @Column(columnDefinition = "TEXT")
    String description;

    String slug;
    String thumbnail;

    @Column(columnDefinition = "TEXT")
    String content;

    Boolean status;
    Date createdAt;
    Date updatedAt;
    Date publishedAt;

    @ManyToOne
    @JoinColumn(name="author_id")
    private User user;
}
