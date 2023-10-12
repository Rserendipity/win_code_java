import java.util.LinkedList;

public class MyQueue<E> {
    private LinkedList<E> ll;

    public void push(E e) {
        ll.addLast(e);
    }

    public E pop() {
        return ll.removeFirst();
    }

    public E front() {
        return ll.getFirst();
    }

    public int size() {
        return ll.size();
    }

    public boolean isEmpty() {
        return ll.isEmpty();
    }
}
