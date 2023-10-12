import java.util.ArrayList;
import java.util.List;

public class MyStack<E> {
    private final List<E> lt;

    public MyStack() {
        lt = new ArrayList<>();
    }

    public void push(E e) {
        lt.add(e);
    }

    public E peek() {
        if (lt.isEmpty())
            throw new IndexOutOfBoundsException();
        return lt.get(lt.size() - 1);
    }

    public E pop() {
        if (lt.isEmpty())
            throw new IndexOutOfBoundsException();
        return lt.remove(lt.size() - 1);
    }

    public boolean isEmpty() {
        return lt.isEmpty();
    }

    public int size() {
        return lt.size();
    }
}
