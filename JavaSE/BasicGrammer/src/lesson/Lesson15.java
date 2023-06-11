package lesson;

class List {
    private final Node head;

    public List() {
        head = new Node(0);
        head.prev = head;
        head.next = head;
    }

    public void pushBack(int val) {
        Node newNode = new Node(val);
        newNode.next = head;
        newNode.prev = head.prev;
        head.prev.next = newNode;
        head.prev = newNode;
    }

    public void print() {
        Node cur = head.next;
        while (cur != head) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }


    /*
     * 静态内部类，外部可以直接用外部类的 类名.内部类 来创建对象
     * 非静态内部类，外部想使用必须先创建外部对象，才能用
     *
     * */
    static class Node {
        public int val;
        public Node next;
        public Node prev;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }
}

class Test {

    public static void Func() {

        Test.Func();
    }
}

public class Lesson15 {

    public static void main(String[] args) {
        String s = "hello nowcoder";
        int end = s.lastIndexOf(' ');
        System.out.println(s.length() - end - 1);
    }

    public static void main1(String[] args) {
        List lt = new List();
        lt.pushBack(10);
        lt.pushBack(20);
        lt.pushBack(30);
        lt.print();
    }
}
