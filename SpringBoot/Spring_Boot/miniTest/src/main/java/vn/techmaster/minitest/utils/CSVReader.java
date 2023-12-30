package vn.techmaster.minitest.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import vn.techmaster.minitest.db.ProductDB;
import vn.techmaster.minitest.model.Product;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Component
public class CSVReader implements IFileReader{
    @Override
    public List<Product> readFile(String path) {
        try (Reader reader = new FileReader(path);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {
                Product product = new Product(Integer.parseInt(csvRecord.get(0)),
                        csvRecord.get(1),
                        csvRecord.get(2),
                        csvRecord.get(3),
                        Integer.parseInt(csvRecord.get(4)),
                        Double.parseDouble(csvRecord.get(5)),
                        Integer.parseInt(csvRecord.get(6)));
                ProductDB.products.add(product);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return ProductDB.products;
    }
}
