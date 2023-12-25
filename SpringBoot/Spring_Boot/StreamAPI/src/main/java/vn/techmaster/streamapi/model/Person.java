package vn.techmaster.streamapi.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Person {
    private int id;
    private String fullname;
    private String job;
    private String gender;
    private String city;
    private int salary;
    private LocalDate birthday;
}
