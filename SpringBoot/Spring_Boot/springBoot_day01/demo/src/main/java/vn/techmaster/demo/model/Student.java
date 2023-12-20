package vn.techmaster.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@AllArgsConstructor
@ToString
public class Student {
    private int id;
    private String name;

    public Student() {
        System.out.println("Student constructor");
    }
}
