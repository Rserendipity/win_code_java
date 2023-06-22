public class ThreadRunTimeCompare {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        long beginTime = System.currentTimeMillis();
        long n1 = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            n1++;
        }
        long n2 = 0;
        for (long i = 0; i < 100_0000_0000L; i++) {
            n2++;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("interval time: " + (endTime - beginTime));
        /*
         * 间隔时间
         * 293ms
         * 295ms
         * 303ms
         * */
    }

    public static void test2() {
        long beginTime = System.currentTimeMillis();

        Thread t1 = new Thread(() -> {
            long n1 = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                n1++;
            }
        });

        Thread t2 = new Thread(() -> {
            long n2 = 0;
            for (long i = 0; i < 100_0000_0000L; i++) {
                n2++;
            }
        });
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long endTime = System.currentTimeMillis();
        System.out.println("interval time: " + (endTime - beginTime));
    }
}
