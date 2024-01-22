package vn.techmaster.movieapp.model.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RegisterRequest {
    String email;
    String password;
    String name;
    String confirmPassword;
}
