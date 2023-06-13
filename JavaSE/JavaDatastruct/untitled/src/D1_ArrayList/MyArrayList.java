package D1_ArrayList;

import java.util.Arrays;

public class MyArrayList<E extends Comparable<E>> {
    private static final int DEFAULT_SIZE = 10;
    private Object[] element;
    private int size;
    private int capacity;

    public MyArrayList() {
        element = new Object[DEFAULT_SIZE];
        size = 0;
        capacity = DEFAULT_SIZE;
    }

    private String format() {
        if (size == 0) {
            return "[]";
        }
        StringBuilder str = new StringBuilder();
        str.append('[');
        for (int i = 0; ; i++) {
            str.append(element[i]);
            if (i == size - 1) {
                str.append(']');
                break;
            }
            str.append(", ");
        }
        return str.toString();
    }

    @Override
    public String toString() {
        String str = format();
        return "MyArrayList{" +
                "array=" + str +
                ", size=" + size +
                ", capacity=" + capacity +
                '}';
    }

    public void add(E e) {
        add(size, e);
    }

    public void add(int index, E e) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (size == capacity) {
            element = Arrays.copyOf(element, 2 * capacity);
            capacity *= 2;
        }

        for (int i = size - 1; i >= index; i--) {
            element[i + 1] = element[i];
        }
        element[size++] = e;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public E elementData(int index) {
        return (E) element[index];
    }

    public E get(int index) {
        checkIndex(index);
        return elementData(index);
    }

    public E set(int index, E newVal) {
        checkIndex(index);
        E oldVal = elementData(index);
        element[index] = newVal;
        return oldVal;
    }

    public int indexOf(Object o) {
        return indexOfRange(o, 0, size);
    }

    public int indexOfRange(Object o, int begin, int end) {
        if (begin < 0 || end > size) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = begin; i < end; i++) {
            if (o.equals(element[i]))
                return i;
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        return lastIndexOfRange(o, 0, size);
    }

    public int lastIndexOfRange(Object o, int begin, int end) {
        for (int i = end - 1; i >= 0; i--) {
            if (o.equals(element[i]))
                return i;
        }
        return -1;
    }

    public boolean contains(Object o) {
        int index = indexOf(o);
        return index != -1;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E oldVal = elementData(index);
        for (int i = index; i < size - 1; i++) {
            element[i] = element[i + 1];
        }
        element[--size] = null;
        return oldVal;
    }

    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            element[i] = null;
        }
        size = 0;
    }

//    int indexOf(Object o) 返回第一个 o 所在下标
//    int lastIndexOf(Object o) 返回最后一个 o 的下标
//    E get(int index) 获取下标 index 位置元素
//    E set(int index, E element) 将下标 index 位置元素设置为 element
//    boolean add(E e) 尾插 e
//    void add(int index, E element) 将 e 插入到 index 位置
//    boolean addAll(Collection<? extends E> c) 尾插 c 中的元素
//    boolean contains(Object o) 判断 o 是否在线性表中
//    E remove(int index) 删除 index 位置元素
//    boolean remove(Object o) 删除遇到的第一个 o
//    void clear() 清空


//    List<E> subList(int fromIndex, int toIndex) 截取部分 list

}
