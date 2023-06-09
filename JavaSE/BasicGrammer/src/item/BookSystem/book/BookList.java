package item.BookSystem.book;

public class BookList {
    private static final int MAX_BOOK_SIZE = 10;
    private final Book[] books = new Book[MAX_BOOK_SIZE];
    private int index;

    public BookList() {
        books[0] = new Book("123", "cjj", 10, "story");
        books[1] = new Book("456", "cjj", 20, "story");
        books[2] = new Book("789", "cjj", 30, "story");
        index = 3;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Book getBook(int index) {
        return books[index];
    }
}
