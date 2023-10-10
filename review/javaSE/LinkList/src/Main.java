import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) {
        List<Integer> lt = new ArrayList<>();
        lt.add(10);

        MyList<Integer> lt2 = new MyArrayList<>(5);
        lt2.add(1);
        lt2.add(1);
        lt2.add(1);
        lt2.add(1);
        lt2.add(1);

        lt2.remove(3);
    }

//    public static void main(String[] args) {
//        Stack<Integer> st = new Stack<>();
//    }
//
//    public static void main1(String[] args) {
//        List<Integer> lt1 = new ArrayList<>();
//        lt1.add(10);
//        lt1.add(20);
//
//        List<Integer> lt2 = new ArrayList<>();
//
//        lt2.add(99);
//        lt2.addAll(lt1);
//
//        java.util.Iterator<Integer> it = lt2.iterator();
//        while (it.hasNext()) {
//            System.out.print(it.next() + " ");
//        }

//        for (Integer e : lt2) {
//            System.out.print(e + " ");
//        }


//        Integer a = 127;
//        Integer b = 127;
//        Integer c = 128;
//        Integer d = 128;
//        System.out.println(a.equals(b));
//        System.out.println(c.equals(d));
//      }
}
