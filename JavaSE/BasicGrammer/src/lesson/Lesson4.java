package lesson;

import java.util.Random;
import java.util.Scanner;

public class Lesson4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int randNum = rand.nextInt(10);
        while (true) {
            System.out.println("输入你要猜的数");
            int n = scan.nextInt();
            if (n == randNum) {
                System.out.println("猜对了");
                break;
            } else if (n > randNum) {
                System.out.println("大了");
            } else {
                System.out.println("小了");
            }
        }
    }

    public static void main2(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        String name = scan.next();
        System.out.println(n);
        System.out.println(name);
    }


    public static void main1(String[] args) {
        /*
         * if / else 和 C/C++类似
         * 但是 Java 的 if 里只能是 boolean 类型表达式
         * if (a = 10)  // 非法，会报错
         *
         *
         * switch 和 C/C++类似，但有差异：
         * case 支持的类型包括：
         * byte、char、short、int、Stirng
         * 不支持：
         * long、float、double、boolean
         *
         *
         * for/while 和 C/C++ 一致
         * break/continue 和 C/C++ 一致
         */

        //
        // 找出1-100之间，既能被3整除，又能被5整除的数
        //


        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println(i);
        }
    }
}
