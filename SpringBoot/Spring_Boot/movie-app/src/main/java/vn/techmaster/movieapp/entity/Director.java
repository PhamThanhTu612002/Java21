package vn.techmaster.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "directors")
@ToString
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String director_name;
    Date birthday;
    @Column(columnDefinition = "TEXT")
    String description;
    String avatar;
    @ManyToMany(mappedBy = "directors")
    List<Movie> movies;
}
