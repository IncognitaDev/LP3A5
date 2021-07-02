import java.util.Optional;

public class B {

    public static void main(String[] args) {
        Optional<String> a = Optional.empty();
        Optional<String> b = Optional.of("Com Valor");


        System.out.println(a.orElse("Vazio"));
        System.out.println(a.orElseGet(() -> "Vazio"));

        System.out.println(b.orElse("Vazio"));
        System.out.println(b.orElseGet(() -> "Vazio"));
    }
}
