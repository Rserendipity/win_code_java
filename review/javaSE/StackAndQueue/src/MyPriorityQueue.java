import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MyPriorityQueue<E> implements Comparator<? extends E> {
    private List<E> lt;

    public MyPriorityQueue() {
        lt = new ArrayList<>();
    }

    public void push(E e) {
        lt.add(e);
        adjust_up(lt.size() - 1);
    }

    public int size() {
        return lt.size();
    }

    public boolean isEmpty() {
        return lt.isEmpty();
    }

    public E top() {
        if (isEmpty())
            throw new RuntimeException("PriorityQueue is empty");
        swap(0, lt.size() - 1);
        E ret = lt.remove(lt.size() - 1);
        adjust_down(0);
        return ret;
    }

    private void swap(int i, int j) {
        E t = lt.get(i);
        lt.set(i, lt.get(j));
        lt.set(j, t);
    }

    private void adjust_up(int child) {
        // 向上调整
        int parent = (child - 1) / 2;
        while (child > 0) {
            if (lt.get(parent) < lt.get(child)) {

            } else {
                break;
            }
        }
    }

    private void adjust_down(int parent) {

    }

}
