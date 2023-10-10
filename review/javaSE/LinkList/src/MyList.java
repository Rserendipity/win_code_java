
public interface MyList<E> {
    boolean add(E e);

    void add(int index, E e);

    E remove(int index);

    boolean remove(Object o);

    E get(int index);

    E set(int index, E element);

    void clear();

    boolean contains(Object o);

    int indexOf(Object o);

    int lastIndexOf(Object o);

    MyList<E> subList(int fromIndex, int toIndex);
}
