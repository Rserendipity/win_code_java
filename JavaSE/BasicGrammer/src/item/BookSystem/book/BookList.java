package item.BookSystem.book;

/**
 * @projectName: BasicGrammer
 * @package: item.BookSystem.book
 * @className: BookList
 * @author: cjj
 * @description: TODO
 * @date: 2023/6/8 19:36
 */
public class BookList {
    private static final int MAX_BOOK_SIZE = 10;
    private final Book[] books = new Book[MAX_BOOK_SIZE];
    private int index = 0;


    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
