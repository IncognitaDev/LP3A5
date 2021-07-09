import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("digite um numero");
        int i = s.nextInt();

        int res = Stream.iterate(i, n -> --n).limit(i).reduce(1, (acc, n) -> acc * n);
        System.out.println(res);
    }
}
