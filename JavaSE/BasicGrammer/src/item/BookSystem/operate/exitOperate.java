package item.BookSystem.operate;

import item.BookSystem.book.BookList;

public class exitOperate implements IOperate {
    @Override
    public void work(BookList bookList) {
        System.out.println("exit");
        System.exit(0);
    }
}
