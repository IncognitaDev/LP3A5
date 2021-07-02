import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Optional<Integer> a = Optional.empty();
        Optional<Integer> b = Optional.of(1);

        try {
            a.orElseThrow(() -> new NullPointerException("Variavel Vazia"));
        }catch (Exception e){
           String message = e.getMessage();
           System.out.println(message);
        }
        System.out.println(b.orElseThrow(() -> new NullPointerException("Variavel Vazia")));
    }
}
