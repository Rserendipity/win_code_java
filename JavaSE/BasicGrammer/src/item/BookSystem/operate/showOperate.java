package item.BookSystem.operate;

import item.BookSystem.book.BookList;

public class showOperate implements IOperate {
    @Override
    public void work(BookList bookList) {
        // System.out.println("show book");
        for (int i = 0; i < bookList.getIndex(); i++) {
            System.out.println(bookList.getBook(i));
        }
    }
}
