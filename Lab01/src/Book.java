import java.util.Objects;

public class Book {
    String name;
    int bookNum;
    static int bookCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBookNum() {
        return bookNum;
    }

    public void setBookNum(int bookNum) {
        this.bookNum = bookNum;
    }

    public Book() {
        name = null;
        bookNum = 0;
        bookNum = bookNumGenerator();
        bookCount++;
    }

    public Book(Book book) {
        name = book.name;
        bookNum = book.bookNum;
        bookNum = bookNumGenerator();
        bookCount++;
    }

    public Book(String name, int bookNum, int bookCount) {
        this.name = name;
        this.bookNum = bookNum;
        Book.bookCount = bookCount;
        this.bookNum = bookNumGenerator();
        Book.bookCount++;
    }

    private int bookNumGenerator() {
        return bookCount + 10 + 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return bookNum == book.bookNum &&
                Objects.equals(name, book.name) &&
                bookCount == book.bookCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bookNum);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", bookNum=" + bookNum +
                ", bookCount=" + bookCount +
                '}';
    }
}
