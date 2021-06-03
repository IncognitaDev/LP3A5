package isAlive;

public class Main2 {
    public static void main(String[] args) {
        MinhaThreadRunnable threadRunnable1 = new MinhaThreadRunnable("thread 1", 500);
        MinhaThreadRunnable threadRunnable2 = new MinhaThreadRunnable("thread 2", 500);

        Thread t1 = new Thread(threadRunnable1);
        Thread t2 = new Thread(threadRunnable2);

        t1.start();
        t2.start();


        try {
           t1.join(); t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Programa finalizado");
    }

}
