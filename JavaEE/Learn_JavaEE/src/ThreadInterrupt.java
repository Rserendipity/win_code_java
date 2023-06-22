public class ThreadInterrupt {
    public static void main(String[] args) throws InterruptedException {
        var t = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("hello world" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                    System.out.println("interrupt");
                    break; // 收到中断信号以后,直接退出
                }
            }
        });
        t.start();
        t.join();

        /*
         t.start(); // 非法的操作, 在线程执行完毕以后,状态会被设置成terminated
         t.join();
        */

    }

    public static void main1(String[] args) throws InterruptedException {
        var t1 = new Thread(() -> {
            while (true) {
                System.out.println("hello world");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // e.printStackTrace();
                    System.out.println("interrupt");
                    break; // 收到中断信号以后,直接退出
                }
            }
        });
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();

        for (var state : Thread.State.values()) {
            System.out.println(state);
        }
    }
}
