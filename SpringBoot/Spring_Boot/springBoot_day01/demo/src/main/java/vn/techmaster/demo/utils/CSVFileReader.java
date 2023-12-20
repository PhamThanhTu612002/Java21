package vn.techmaster.demo.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import vn.techmaster.demo.database.BookDB;
import vn.techmaster.demo.model.Book;

import java.io.*;
import java.util.List;
@Component
public class CSVFileReader implements IFileReader{
    @Override
    public List<Book> readFile(String path) {
        try (Reader reader = new FileReader(path);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            // Iterate over CSV records
            for (CSVRecord csvRecord : csvParser) {
                Book book = new Book(Integer.parseInt(csvRecord.get(0)),csvRecord.get(1),csvRecord.get(2),Integer.parseInt(csvRecord.get(3)));
                BookDB.bookList.add(book);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return BookDB.bookList;
    }
}
