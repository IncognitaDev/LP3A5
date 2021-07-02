import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> names  = Arrays.asList(
                "Paulo",
                "Camila",
                "Ana Maria",
                "Patrick",
                "Ana Clara",
                "Pedro",
                "Alfredo");

        names.stream()
                .filter(n -> n.startsWith("W"))
                .findAny()
                .orElseThrow(() -> new NullPointerException("Nomes com esta letra não constam na lista"));

    }
}
