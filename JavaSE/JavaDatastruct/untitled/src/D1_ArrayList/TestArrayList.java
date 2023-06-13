package D1_ArrayList;

import java.util.LinkedList;

public class TestArrayList {
    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(10);
        arr.add(20000);
        arr.add(30);
        System.out.println(arr);
//        System.out.println(arr.get(1));
//        System.out.println(arr.get(2));

        System.out.println("index = " + arr.indexOf(20000));
        System.out.println(arr.contains(10));

        arr.remove(0);
        arr.remove(0);
        // arr.remove(0);
        System.out.println(arr);
        arr.remove((Integer) 30);
        System.out.println(arr);

        // System.out.println(arr.get(3)); // out of range
//        try {
//            arr.add(5, 20);
//        } catch (IndexOutOfBoundsException e) {
//            System.out.println("this");
//            e.printStackTrace();
//        }

        var lt = new LinkedList<Integer>();
        lt.add(10);

    }
}
