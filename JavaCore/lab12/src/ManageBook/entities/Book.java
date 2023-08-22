package ManageBook.entities;

public class Book {
    private int id;
    private static int autoId;
    private String name;
    private String title;
    private String author;
    private int numOfBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumOfBook() {
        return numOfBook;
    }

    public void setNumOfBook(int numOfBook) {
        this.numOfBook = numOfBook;
    }

    public Book(String name, String title, String author, int numOfBook) {
        this.id = ++autoId;
        this.name = name;
        this.title = title;
        this.author = author;
        this.numOfBook = numOfBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", numOfBook=" + numOfBook +
                '}';
    }
}
