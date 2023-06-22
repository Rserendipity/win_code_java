class ThreadTask {
    public int count = 0;

    public void add() {
        synchronized (this) {
            count++;
        }
    }

    synchronized public void add(int a) {
        count++;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}


public class ThreadLock {
    public static void main(String[] args) {
        var task = new ThreadTask();
        var t1 = new Thread(() -> {
            for (int i = 0; i < 2000000; i++) {
                task.add();
                // task.add(10);
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 0; i < 2000000; i++) {
                task.add();
                // task.add(10);
            }
        });

        var begin = System.currentTimeMillis();
        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        var end = System.currentTimeMillis();


        System.out.println(task.getCount());
        System.out.println(end - begin);

    }
}
