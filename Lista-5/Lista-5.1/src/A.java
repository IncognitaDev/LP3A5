import java.util.Optional;

public class A {
    public static void main(String[] args) {
        Optional<String> a = Optional.empty();

        System.out.println(a.orElse("Vazio"));

        System.out.println(a.orElseGet(() -> "Vazio"));
    }
}
