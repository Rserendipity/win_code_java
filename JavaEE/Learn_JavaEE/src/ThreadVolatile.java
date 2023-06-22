import java.util.Scanner;

class MyCount {
    // public int flag = 0; // cannot to change in thread-1
    volatile public int flag = 0; // 告诉编译器, 每一次取值的时候, 都去内存取, 而不是直接从寄存器里拿
}

public class ThreadVolatile {
    public static void main(String[] args) {
        MyCount myCount = new MyCount();

        var t1 = new Thread(() -> {
            while (myCount.flag == 0) {
                // waiting for flag to non-zero
            }
            System.out.println("t1结束");
        });

        var t2 = new Thread(() -> {
            Scanner cin = new Scanner(System.in);
            System.out.print("Please input a number:>");
            myCount.flag = cin.nextInt();
            System.out.println("t2结束");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            // nothing to do
        }

    }
}
