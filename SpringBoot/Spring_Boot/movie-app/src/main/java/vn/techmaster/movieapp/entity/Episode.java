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
@Table(name = "episodes")
@ToString
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer display_order;
    String video_url;
    Integer duration;
    boolean status;
    Date createdAt;
    Date updatedAt;
    Date publishedAt;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}
