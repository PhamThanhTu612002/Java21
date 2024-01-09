package vn.techmaster.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techmaster.movieapp.model.MovieType;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "movies")
@ToString
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tự động tăng
    Integer id;

    String title; //Nhà bà nữ
    String slug; //nha-ba-nu

    @Column(columnDefinition = "TEXT")
    String description;
    String poster;

    Boolean status;
    Integer releaseYear;
    Integer view;
    Integer rating;

    @Enumerated(EnumType.STRING)
    MovieType movieType;

    Date createdAt;
    Date updatedAt;
    Date publishedAt;
}
