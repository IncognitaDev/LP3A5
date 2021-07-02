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

        boolean has = names.stream().filter(n -> n.startsWith("W")).findAny().isPresent();
        if(!has) {
            System.out.println("Nomes com esta letra não consta na lista");
        }
    }
}
