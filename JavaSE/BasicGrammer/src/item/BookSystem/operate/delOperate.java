package item.BookSystem.operate;

import item.BookSystem.book.BookList;

public class delOperate implements IOperate {
    @Override
    public void work(BookList bookList) {
        System.out.println("del book");
    }
}
