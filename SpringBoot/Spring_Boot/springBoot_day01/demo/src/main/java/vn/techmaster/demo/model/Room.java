package vn.techmaster.demo.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*Inject Bean như thế nào?
C1: Đánh dấu field (sử dụng @Autowired)
C2: Đánh dấu constructor
C3: Đánh dấu Setter
* */
@Component
@Getter
@Setter
@ToString
public class Room {
    private int id;
    private final Student student;
    private final Teacher teacher;

    public Room( Student student, Teacher teacher) {
        this.student = student;
        this.teacher = teacher;
    }

//    public Room(){
//        System.out.println("Room constructor");
//    }
}
