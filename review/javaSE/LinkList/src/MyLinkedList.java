public class MyLinkedList<E> implements MyList<E> {

    class Node<E> {
        public E e;
        public Node<E> prev;
        public Node<E> next;

        public Node(E e) {
            this.e = e;
            prev = next = null;
        }
    }


    private Node<E> head;
    private Node<E> last;
    private int size;

    public MyLinkedList() {
        head = last = null;
        size = 0;
    }

    @Override
    public boolean add(E e) {
        if (head == null) {
            head = last = new Node<>(e);
        } else {
            Node<E> node = new Node<>(e);
            last.next = node;
            node.prev = last;
            last = node;
        }
        size++;
        return true;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void addFront(E e) {
        if (head == null) {
            head = last = new Node<>(e);
        } else {
            Node<E> node = new Node<>(e);
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        checkIndex(index);
        if (index == 0) {
            addFront(e);
        } else if (index == size) {
            add(e);
        } else {

            Node<E> cur = head, node = new Node<>(e);
            for (int i = 0; i < index - 1; i++) {
                cur = cur.next;
            }
            node.next = cur.next;
            node.prev = cur;
            cur.next.prev = node;
            cur.next = node;
            size++;
        }

    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        Node<E> node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return remove(node);
    }

    public E remove(Node<E> node) {
        size--;
        node.next.prev = node.prev;
        node.prev.next = node.prev;
        return node.e;
    }

    @Override
    public boolean remove(Object o) {
        Node<E> node = head;
        while (node != null) {
            if (node.e.equals(o)) {
                remove(node);
                return true;
            }
            node = node.next;
        }
        return false;
    }

    Node<E> getNode(int index) {
        Node<E> cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        Node<E> node = getNode(index);
        return node.e;
    }

    @SuppressWarnings("nochecked")
    E getElement(Node<E> node) {
        return (E)node.e;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = getNode(index);
        E e = getElement(node);
        node.e = element;
        return e;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) != -1;
    }

    @Override
    public int indexOf(Object o) {
        Node<E> node = head;
        for (int i =0; node != null; i++) {
            if (node.e.equals(o)) return i;
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<E> node = last;
        for (int i = size - 1; node !=null; i--) {
            if (node.e.equals(o)) return i;
            node = node.prev;
        }
        return -1;
    }

    @Override
    public MyList<E> subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkIndex(toIndex);
        Node<E> cur = head;
        for (int i = 0; i < fromIndex; i++) {
            cur = cur.next;
        }
        MyList<E> lt = new MyLinkedList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            lt.add(cur.e);
            cur = cur.next;
        }
        return lt;
    }
}
