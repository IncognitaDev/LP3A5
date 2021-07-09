import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Paulo", "Camila", "Ana Maria", "Patrick", "Ana Clara", "Pedro", "Alfredo");

        Optional<String> pConcat = list.stream().filter(n -> n.startsWith("P")).reduce((acc, n) -> acc + ", " + n);
        Optional<String> aConcat = list.stream().filter(n -> n.startsWith("A")).reduce((acc, n) -> acc + ", " + n);
        Optional<String> allConcat = list.stream().reduce((acc, n) -> acc + ", " + n);

        pConcat.ifPresent(System.out::println);
        aConcat.ifPresent(System.out::println);
        allConcat.ifPresent(System.out::println);
    }
}
