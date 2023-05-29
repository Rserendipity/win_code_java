package lesson;


public class Lesson6 {

    public static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        /*
         * Java中的函数递归和C/C++保持一致
         *
         * */
        System.out.println(fib(7));
    }


    /**
     * 可以构成函数重载
     */
    public static int sum(int a, int b) {
        return a + b;
    }

    public static double sum(double d1, double d2) {
        return d1 + d2;
    }

    public static void main1(String[] args) {
        /*
         * Java中的 “函数” 叫 “方法”
         * 只是需要写上 访问修饰符 和 作用修饰符
         * 其余地方和 C/C++ 相似，也可以进行函数重载，重载条件和 C++一致
         * */
        System.out.println(sum(10, 20));
        System.out.println(sum(10.3, 20.1));
    }
}
