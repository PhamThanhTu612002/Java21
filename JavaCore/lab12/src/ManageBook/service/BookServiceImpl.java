package ManageBook.service;

import ManageBook.entities.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookServiceImpl implements IBook{
    Scanner sc = new Scanner(System.in);

    @Override
    public ArrayList<Book> insertBook(ArrayList<Book> books) {
        System.out.println("Nhập name: ");
        String name = sc.nextLine();
        System.out.println("Nhập title: ");
        String title = sc.nextLine();
        System.out.println("Nhập author: ");
        String author = sc.nextLine();
        System.out.println("Nhập nob: ");
        int nob = Integer.parseInt(sc.nextLine());
        Book book = new Book(name,title,author,nob);
        books.add(book);
        return books;
    }

    @Override
    public ArrayList<Book> updateBook(ArrayList<Book> books) {
        System.out.println("Nhập id cần sửa:");
        int id = Integer.parseInt(sc.nextLine());
        for (Book book : books){
            if (id == book.getId()){
                System.out.println("1. Name");
                System.out.println("2. Title");
                System.out.println("3. Author");
                System.out.println("4. Number Of Book: ");
                System.out.println("0. Exit");
                System.out.println("Nhập thông tin cần sửa:");
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        System.out.println("Nhập name cần sửa:");
                        book.setName(sc.nextLine());
                        break;
                    case 2:
                        System.out.println("Nhập title cần sửa:");
                        book.setTitle(sc.nextLine());
                        break;
                    case 3:
                        System.out.println("Nhập tên cần sửa:");
                        book.setName(sc.nextLine());
                        break;
                    case 4:
                        System.out.println("Nhập tên cần sửa:");
                        book.setName(sc.nextLine());
                        break;
                    case 0:
                        break;
                }
            }
        }
    }

    @Override
    public ArrayList<Book> deleteBook(ArrayList<Book> books) {
        return null;
    }
}
