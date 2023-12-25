package vn.techmaster.streamapi.utils;

import vn.techmaster.streamapi.model.Person;

import java.util.List;

public interface IFileReader {
    List<Person> readFile(String path);
}
