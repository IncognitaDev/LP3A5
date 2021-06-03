package interfaceRunnable;

public class Main {
    public static void main(String[] args) {
        MinhaThreadRunnable threadRunnable1 = new MinhaThreadRunnable("thread 1", 500);
        MinhaThreadRunnable threadRunnable2 = new MinhaThreadRunnable("thread 2", 500);
    }
}
