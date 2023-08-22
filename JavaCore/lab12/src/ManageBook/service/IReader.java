package ManageBook.service;

import ManageBook.entities.Reader;

import java.util.ArrayList;

public interface IReader {
    ArrayList<Reader> inserReader(ArrayList<Reader> readers);
    ArrayList<Reader> updateReader(ArrayList<Reader> readers);
    ArrayList<Reader> deleteReader(ArrayList<Reader> readers);
    Reader searchReader();

}
