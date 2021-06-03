package priority;

import interfaceRunnable.MinhaThreadRunnable;

public class Priority {
    public static void main(String[] args) {
        MinhaThreadRunnable threadRunnable1 = new MinhaThreadRunnable("thread 1", 500);
        MinhaThreadRunnable threadRunnable2 = new MinhaThreadRunnable("thread 2", 500);
        MinhaThreadRunnable threadRunnable3 = new MinhaThreadRunnable("thread 3", 500);

        Thread t1 = new Thread(threadRunnable1);
        Thread t2 = new Thread(threadRunnable2);
        Thread t3 = new Thread(threadRunnable3);

        t1.setPriority(10);
        t2.setPriority(3);
        t3.setPriority(1);

        t2.start();
        t1.start();
        t3.start();
    }
}
