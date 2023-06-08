package item.BookSystem.user;

public abstract class User {
    protected String name;

    public User(String name) {
        this.name = name;
    }

    public abstract int menu();
}
