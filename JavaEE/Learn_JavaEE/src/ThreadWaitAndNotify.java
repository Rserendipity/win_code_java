public class ThreadWaitAndNotify {
    public static void main(String[] args) throws InterruptedException {
        /*
         * wait是主动的等待,会释放掉所有的锁资源,然后进入waiting状态,等待其他线程唤醒它
         * notify唤醒一个对象上的等待线程,如果没有线程等待这个对象,那么什么也不会发生
         * */

        // 共享的对象,加锁和解锁  wait和notify都发生在这个对象身上
        Object ob = new Object();

        // 加锁ob对象,然后wait,等待别的线程唤醒
        var t1 = new Thread(() -> {
            System.out.println("before wait...");
            synchronized (ob) { // 线程t1对ob对象加锁, 然后wait, wait的时候会把锁释放掉,等待通知
                try {
                    ob.wait();
                    // ob.wait(1000); // 重载的版本, 参数为最长的等待时间, 避免死等
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("end wait...");
        });

        var t2 = new Thread(() -> {
            System.out.println("before notify...");
            synchronized (ob) {
                ob.notify();
            }
            System.out.println("end notify...");
        });

        t1.start();
        // 等待一段时间, 使得t1成功的上锁后处于等待状态
        Thread.sleep(1000);
        t2.start();

        t1.join();
        t2.join();
    }
}
