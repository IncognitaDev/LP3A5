import java.util.function.Function;

public class LambdaFatorial {

    public static void main(String[] args) {
        Teste t = new Teste();

        t.f = (n) -> {
            if(n == 1){
                return n;
            }
            return (n * t.f.apply(n-1));
        };

        System.out.println( t.f.apply(5));
    }

    public static class Teste {
        Function<Integer, Integer> f;
    }
}
