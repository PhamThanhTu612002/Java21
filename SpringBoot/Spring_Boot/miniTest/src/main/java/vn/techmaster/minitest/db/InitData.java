package vn.techmaster.minitest.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import vn.techmaster.minitest.MiniTestApplication;
import vn.techmaster.minitest.utils.CSVReader;

import java.net.URL;

@Configuration
public class InitData implements CommandLineRunner {
    @Autowired
    private CSVReader reader;

    @Override
    public void run(String... args) throws Exception {
        URL resourceUrl = MiniTestApplication.class.getClassLoader().getResource("products.csv");
        ProductDB.products = reader.readFile(resourceUrl.getPath());
        System.out.println(ProductDB.products.size());
    }
}
