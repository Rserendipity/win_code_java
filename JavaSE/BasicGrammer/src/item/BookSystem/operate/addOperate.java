package item.BookSystem.operate;

import item.BookSystem.book.BookList;

public class addOperate implements IOperate {
    @Override
    public void work(BookList bookList) {
        System.out.println("add book");
    }
}
