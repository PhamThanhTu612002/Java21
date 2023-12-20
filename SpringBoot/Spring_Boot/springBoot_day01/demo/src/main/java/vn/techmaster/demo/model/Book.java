package vn.techmaster.demo.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private int id;
    private String title;
    private String author;
    private int year;
}
