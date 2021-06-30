import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Scanner imput = new Scanner(System.in);

        System.out.println("Digie o numero final");
        int n = imput.nextInt();

        List<Integer> list =
                Stream.iterate(1, i -> i <= n, integer -> integer + 1)
                        .map(i -> Arrays.asList(i,i))
                        .flatMap(Collection::stream)
                        .toList();

        System.out.println("lista");
        list.forEach(System.out::println);

        System.out.println("unico");
        list.stream()
                .distinct()
                .forEach(System.out::println);

        System.out.println("impar");
        list.stream()
                .distinct()
                .filter(i -> i % 2 == 1)
                .forEach(System.out::println);

        System.out.println("par");
        list.stream()
                .distinct()
                .filter(i -> i % 2 == 0)
                .forEach(System.out::println);

        System.out.println("maior que cinco");
        list.stream()
                .distinct()
                .filter(i -> i < 5)
                .forEach(System.out::println);

        System.out.println("multiplicado por 4");
        list.stream()
                .map(i -> i * 4)
                .forEach(System.out::println);
    }
}
