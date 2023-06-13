package D2_LinkList;

import java.util.NoSuchElementException;

public class MyLinkedList<E> {

    private Node<E> first;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
    }

    public boolean add(E val) {
        addLast(val);
        return true;
    }

    public boolean add(int index, E val) {
        addIndex(index, val);
        return true;
    }

    //头插法
    public void addFirst(E val) {
        Node<E> newNode = new Node<>(val);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.next = first;
            first.prev = newNode;
            first = newNode;
        }
        size++;
    }

    //尾插法
    public void addLast(E val) {
        Node<E> newNode = new Node<>(val);
        if (first == null) {
            first = last = newNode;
        } else {
            newNode.prev = last;
            last.next = newNode;
            last = newNode;
        }
        size++;
    }

    //任意位置插入,第一个数据节点为 0号下标
    public void addIndex(int index, E val) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addFirst(val);
            return;
        }
        if (index == size) {
            addLast(val);
            return;
        }

        Node<E> cur = first;
        for (int i = 0; i < index && cur != null; i++) {
            cur = cur.next;
        }
        Node<E> newNode = new Node<>(val);
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        size++;
    }

    public int indexOf(E val) {
        Node<E> cur = first;
        for (int i = 0; cur != null; i++) {
            if (cur.val == val) {
                return i;
            }
            cur = cur.next;
        }
        return -1;
    }

    //查找是否包含关键字key是否在单链表当中
    public boolean contains(E key) {
        int index = indexOf(key);
        return index != -1;
    }

    public void removeFirst() {
        Node<E> cur = first;
        if (cur == null) {
            throw new NoSuchElementException();
        }
        cur = first.next;
        if (cur != null) {
            cur.prev = null;
        }
        first.next = null;
        first = cur;
        size--;
    }

    public void removeLast() {
        Node<E> cur = last;
        if (cur == null) {
            throw new NoSuchElementException();
        }
        cur = last.prev;
        if (cur != null) {
            cur.next = null;
        }
        last.prev = null;
        last = cur;
        size--;
    }

    //删除所有值为key的节点

    public void removeAllKey(E key) {
    }

    //得到单链表的长度
    public int size() {
        return size;
    }

    public void display() {
        System.out.println(this);
    }

    public void clear() {
        while (first != null) {
            Node<E> save = first.next;
            first.prev = null;
            first.next = null;
            first = save;
        }
        last = null;
        size = 0;
    }

    private String format() {
        if (first == null) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            Node<E> cur = first;
            while (cur != null) {
                sb.append(cur.val);
                if (cur != last)
                    sb.append(", ");
                cur = cur.next;
            }
            return sb.append(']').toString();
        }
    }

    @Override
    public String toString() {
        String s = format();
        return "MyLinkedList{" +
                s +
                ", size=" + size +
                '}';
    }

    private class Node<E> {
        public E val;
        public Node<E> prev;
        public Node<E> next;

        public Node(E val) {
            this.val = val;
        }

        public Node(E val, Node<E> prev, Node<E> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }
}
