import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> l = Arrays.asList("Paulo",
                "Camila",
                "Ana Maria",
                "Patrick",
                "Ana Clara",
                "Pedro",
                "Alfredo");
        l.stream().filter(s -> s.startsWith("P")).forEach(System.out::println);
        l.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);
        Map<Boolean, List<String>> group = l.stream().collect(Collectors.groupingBy(n -> n.startsWith("A")));

        System.out.println("Começam com A");
        group.get(true).stream().forEach(System.out::println);
        System.out.println("Não Começam com A");
        group.get(false).stream().forEach(System.out::println);

        Map<Integer, List<String>> groupByLegth = l.stream().map(String::toUpperCase).collect(Collectors.groupingBy(String::length));

        System.out.println("Agrupado por tamanho");
        groupByLegth.values().stream().map(n -> n.stream().collect(Collectors.joining(","))).forEach(System.out::println);
    }
}
