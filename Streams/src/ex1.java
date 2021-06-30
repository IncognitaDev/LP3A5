import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ex1 {

    public static void main(String[] args) {
        List<Integer> numbers =  Arrays.asList(1,2,3,4,5,6,7,7);

        numbers.stream().filter(n -> n > 5).forEach(System.out::println);
        numbers.stream().filter(n -> n > 5).map(n -> n * n).forEach(System.out::println);
        Stream.iterate(1, n -> n < 20, n -> n * 2).forEach(System.out::println);

        ArrayList<String> alunos = new ArrayList<String>();
        alunos.add("John");
        alunos.add("Ana");
        alunos.add("Carla");
        String agrupamento = alunos.stream().collect(Collectors.joining(", "));
        System.out.println("Lista de alunos: " + agrupamento);

        String[][] array = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"}};

        List<String> collect = Stream.of(array).flatMap(Stream::of).collect(Collectors.toList());

        collect.forEach(System.out::println);

    }
}
