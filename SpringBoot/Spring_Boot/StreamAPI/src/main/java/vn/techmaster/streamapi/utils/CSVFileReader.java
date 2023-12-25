package vn.techmaster.streamapi.utils;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import vn.techmaster.streamapi.database.PersonDB;
import vn.techmaster.streamapi.model.Person;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
@Component
public class CSVFileReader implements IFileReader{
    @Override
    public List<Person> readFile(String path) {
        try (Reader reader = new FileReader(path);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {

            // Iterate over CSV records
            for (CSVRecord csvRecord : csvParser) {
                Person person = new Person(Integer.parseInt(csvRecord.get(0)),
                        csvRecord.get(1), csvRecord.get(2),
                        csvRecord.get(3), csvRecord.get(4),
                        Integer.parseInt(csvRecord.get(5)), LocalDate.parse(csvRecord.get(6), DateTimeFormatter.ofPattern("yyyy/MM/dd")));
                PersonDB.personList.add(person);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
        return PersonDB.personList;
    }
}
