package vn.techmaster.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import vn.techmaster.demo.model.Room;
import vn.techmaster.demo.model.Student;
import vn.techmaster.demo.model.Teacher;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
		Student student = context.getBean(Student.class);
		System.out.println(student);

		Teacher teacher = context.getBean(Teacher.class);
		System.out.println(teacher);

		//Lấy ra đối tượng Room ừ Spring IOC container
		Room room = context.getBean(Room.class);
		System.out.println(room);
	}
	@Bean // Chỉ sử dụng trong class được đánh dấu là @Configuration
	//Method trả về đối tượngdduowcjc gọi là bean
	public Teacher getTeacher(){
		return new Teacher(1,"Teacher 1");
	}

	@Override
	public void run(String... args) throws Exception {
	}
}
