import java.util.Arrays;

public class ThreadLambdaList {
    private int[] numbers ;

    public ThreadLambdaList(int[] numbers){
        this.numbers = numbers;

        new Thread(() -> {
            Arrays.stream(this.numbers).forEach(n -> {
                System.out.println(n);
                System.out.println(n * n);
                System.out.println(n * 2);
                System.out.println(n + 3);
                System.out.println("-----");
            });
        }).start();
    }
}
