import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<Integer> list = Stream.generate(() -> new Random().nextInt() + 1).limit(100).collect(Collectors.toList());

        int sum = list.stream().reduce(0 ,Integer::sum);
        int max = list.stream().reduce(Integer.MAX_VALUE ,Integer::max);
        int min = list.stream().reduce(Integer.MIN_VALUE ,Integer::min);
        int mult = list.stream().reduce(1, (acc, n) -> n * n);
        System.out.println("soma: " +sum);
        System.out.println("multiplicação: " + mult);
        System.out.println("maximo: " +max);
        System.out.println("minimo: " + min);
    }
}
