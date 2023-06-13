package D2_LinkList;

public class TestLinkedList {
    public static void main(String[] args) {
//        LinkedList<Integer> lt = new LinkedList<Integer>();
//        lt.add(0, 1);
//        lt.add(0, 2);
//        lt.add(0, 3);
//        System.out.println(lt);

        MyLinkedList<Integer> mylt = new MyLinkedList<Integer>();
        mylt.add(0, 1);
        mylt.add(0, 2);
        mylt.add(0, 3);
        System.out.println(mylt);

        mylt.add(2, 999);
        System.out.println(mylt);
        mylt.add(4, 666);
        System.out.println(mylt);

        mylt.removeLast();
        System.out.println(mylt);


//        mylt.clear();
//        System.out.println(mylt);
    }
}
