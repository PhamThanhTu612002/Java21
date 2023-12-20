package vn.techmaster.demo.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.demo.DemoApplication;
import vn.techmaster.demo.utils.CSVFileReader;
import vn.techmaster.demo.utils.JsonFileReader;

import java.io.File;
import java.net.URL;


@Configuration// Định nghĩa bean
public class InitData implements CommandLineRunner{
    @Autowired
    private JsonFileReader reader;
    @Autowired
    private CSVFileReader csvFileReader;

    @Override
    public void run(String... args) throws Exception {
        URL resourceUrl = DemoApplication.class.getClassLoader().getResource("book.csv");
//        String filePath = System.getProperty("user.dir").concat(File.separator).concat("book.json");
//        BookDB.bookList = reader.readFile(resourceUrl.getPath().toString());
        BookDB.bookList = csvFileReader.readFile(resourceUrl.getPath());
        System.out.println(BookDB.bookList.size());
    }
}
