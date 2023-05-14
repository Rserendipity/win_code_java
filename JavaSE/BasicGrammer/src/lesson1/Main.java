package lesson1;

public class Main {

    public static void main(String[] args) {

    }

    public static void main9(String[] args) {
//        int a = 10;
//        long b = 20L;
//        // a = b // 非法，必须强转
//        a = (int)b; // 强转
//        b = a; // 合法，范围小的可以直接转向范围大的
    }

    public static void main8(String[] args) {
        boolean bool = true;
        System.out.println(bool);
    }

    public static void main7(String[] args) {
        short s = 20;
        System.out.println(s);
        System.out.println(Short.MAX_VALUE);
        System.out.println(Short.MIN_VALUE);
    }

    public static void main6(String[] args) {
        double d = 20.4;
        System.out.println(d);
        System.out.println(Double.MAX_VALUE);
        System.out.println(Double.MIN_VALUE);
    }

    public static void main5(String[] args) {
        float f = 10.0f; // 必须显示的加f，默认的字面浮点数是double型，类型不兼容
        System.out.println(Float.MAX_VALUE);
        System.out.println(Float.MIN_VALUE);
    }

    public static void main4(String[] args) {
        byte b = 10;
        System.out.println(b);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(Byte.MIN_VALUE);
    }

    public static void main3(String[] args) {

        // Java的char是2字节，存放的是unicode编码的字符，所以可以存放中文
        char a = '好'; // 可以存放中文字符
        char b = 97;
        System.out.println(a);
        System.out.println(b);
    }


    public static void main2(String[] args) {
        int a = 10;
        System.out.println(a);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }

    public static void main1(String[] args) {
        System.out.println("hello world!");
    }
}
