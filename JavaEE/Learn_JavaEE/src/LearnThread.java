class Mythread extends Thread {
    @Override
    public void run() {
        System.out.println("hello world");
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("hello");
    }
}

public class LearnThread {
    /*
     * lambda表达式的方式创建
     * */
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("hello world");
        });
        t1.start();
    }

    /*
     * 实现匿名Runnable接口
     * */
    public static void main4(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });
        t1.start();
    }

    /*
     * 匿名内部类实现
     * */
    public static void main3(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        t1.start();
    }

    /*
     * 实现Runnable接口
     * Thread和Runnable分离,实现解耦合,任务是任务,线程是线程
     * */
    public static void main2(String[] args) {

        // 描述任务
        Runnable runnable = new MyRunnable();
        // 把任务交给某个线程并执行
        Thread t1 = new Thread(runnable);
        t1.start();

    }

    /*
     * 写一个子类,继承Thread,重写run方法
     * */
    public static void main1(String[] args) throws InterruptedException {

        Thread t1 = new Mythread();
        t1.start();
        t1.join();
    }
}
