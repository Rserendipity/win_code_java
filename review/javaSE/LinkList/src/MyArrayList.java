public class MyArrayList<E> implements MyList<E> {

    private Object[] element;
    private int size;
    private int capacity;

    public MyArrayList(int capacity) {
        if (capacity <= 0)
            throw new IllegalArgumentException("Capacity: " + capacity);

        this.size = 0;
        this.capacity = capacity;
        element = new Object[capacity];
    }

    private void reverse(int newSize) {
        Object[] newElement = new Object[newSize];
        for (int i = 0; i < element.length; i++) {
            newElement[i] = element[i];
        }
        element = newElement;
        capacity = newSize;
    }

    private void checkCapacity() {
        if (size == capacity) {
            reverse(capacity == 0 ? 10 : 2 * capacity);
        }
    }

    @Override
    public boolean add(E e) {
        checkCapacity();
        element[size++] = e;
        return true;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);
        checkCapacity();
        for (int i = size; i > index; i--) {
            element[i] = element[i - 1];
        }
        element[index] = e;
    }

    @SuppressWarnings("unchecked")
    private E GetElement(int index) {
        return (E) element[index];
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E obj = GetElement(index);
        for (int i = index; i < size - 1; i++) {
            element[i] = element[i + 1];
        }
        size--;
        return obj;
    }

    // 0 1 2 3 4
    // 3 5 4 7 8
    //

    @Override
    public boolean remove(Object o) {
        int i = 0;
        for (; i < size; i++) {
            if (element.equals(o)) break;
        }
        if (i == size) return false;

        remove(i);
        return true;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return GetElement(index);
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldElement = GetElement(index);
        this.element[index] = element;
        return oldElement;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = capacity = 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (element[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (element[i].equals(o)) return i;
        }
        return -1;
    }

    @Override
    public MyList<E> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        MyList<E> newlt = new MyArrayList<>(toIndex - fromIndex);
        for (int i = fromIndex; i < toIndex; i++) {
            newlt.add(get(i));
        }
        return newlt;
    }
}
