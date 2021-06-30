import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
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
        l.stream().collect(Collectors.joining());
    }
}
