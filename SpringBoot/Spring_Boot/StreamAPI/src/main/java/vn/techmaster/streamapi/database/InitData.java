package vn.techmaster.streamapi.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.streamapi.StreamApiApplication;
import vn.techmaster.streamapi.utils.CSVFileReader;


import java.net.URL;


@Configuration
public class InitData implements CommandLineRunner{
    @Autowired
    private CSVFileReader csvFileReader;

    @Override
    public void run(String... args) throws Exception {
        URL resourceUrl = StreamApiApplication.class.getClassLoader().getResource("personsmall.csv");
        PersonDB.personList = csvFileReader.readFile(resourceUrl.getPath());
        System.out.println(PersonDB.personList.size());
        PersonDB.personList.forEach(System.out::println);
    }
}
