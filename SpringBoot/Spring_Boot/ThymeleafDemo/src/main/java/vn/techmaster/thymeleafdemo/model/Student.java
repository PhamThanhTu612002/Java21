package vn.techmaster.thymeleafdemo.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Student {
    int id;
    String name;
    String email;
    String phone;
    int score;
}

/*
* /student, /admin, /blog               : normal path
* /student/1, /student/2                : patch variable
* /student/name=an&email=an@gmail.com   : query String
* */
