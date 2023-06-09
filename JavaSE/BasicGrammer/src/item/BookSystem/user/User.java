package item.BookSystem.user;

import item.BookSystem.book.BookList;
import item.BookSystem.operate.IOperate;

public abstract class User {
    protected String name;
    protected IOperate[] iOperates;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();

    public void doWork(int choice, BookList bookList) {
        iOperates[choice].work(bookList);
    }
}
