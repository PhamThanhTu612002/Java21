package vn.techmaster.movieapp.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import vn.techmaster.movieapp.model.MovieType;
import vn.techmaster.movieapp.model.Role;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "users")
@ToString
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// id tự động tăng
    Integer id;
    String username;

    @Column(nullable = false)
    String password;
    String fullname;
    String avatar;

    @Enumerated(EnumType.STRING)
    Role role;
}
