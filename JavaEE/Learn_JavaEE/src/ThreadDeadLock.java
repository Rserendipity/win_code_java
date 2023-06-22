public class ThreadDeadLock {
    public static void main(String[] args) {
        /*
         * 死锁的三种情况
         * 1. 同一个线程重复获取锁
         *      即同一个线程加锁两次 或者是递归函数重复获取锁
         *      (Java的synchronized可以避免这种情况)
         * 2. 互相持有, 互不释放
         *      两个线程需要对方的锁, 但是都保持自己获取到的锁不释放
         * 3. 哲学家进餐问题
         *      N个人 N只筷子, 只要一人同时有两只筷子就可以吃饭
         *      但是如果恰好每个人都拿了左边的筷子, 即每个人都有一只,等待他人释放
         *      此时会导致死锁, 情况二的延伸
         * */
        var thread = new ThreadDeadLock();
        thread.test1();
    }

    synchronized void test1() {
        synchronized (this) {
            // 这里使用原生的线程库会导致这里死锁, 但是Java的jvm对这种情况做了特殊处理
            // 会判断这个对象和拿到第一个锁的对象是不是同一个,是的话放行
        }
    }

    void test2() {
        Object ob1 = new Object();
        Object ob2 = new Object();

        var t1 = new Thread(() -> {
            synchronized (ob1) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (ob2) {
                    // 这里请求申请ob2, 肯定是不成功的, 因为ob2被t2给申请了, t2又不释放
                    // 所以这里会造成死锁
                }
            }
        });
        var t2 = new Thread(() -> {
            synchronized (ob2) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (ob1) {
                    // 这里请求申请ob1, 肯定是不成功的, 因为ob1被t1给申请了, t1又不释放
                    // 所以这里会造成死锁
                }
            }
        });
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
