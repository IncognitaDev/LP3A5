public class ThreadLambdaRunnable {

    public static void main(String[] args) {
        new Thread(() -> System.out.println(Thread.currentThread())).start();
    }

}
