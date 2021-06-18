import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class ex2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5, 6, 7 , 8 ,9,10);

        System.out.println("todos");
        avaliaExpressao(list, (n) -> true);
        System.out.println("nenhum");
        avaliaExpressao(list, (n) -> false);
        System.out.println("par");
        avaliaExpressao(list, (n) -> n % 2 == 0);
        System.out.println("impar");
        avaliaExpressao(list, (n) -> n % 2 == 1);
        System.out.println(">5");
        avaliaExpressao(list, (n) -> n >5);
        System.out.println("> 5 && < 10");
        avaliaExpressao(list, (n) ->  n > 5 && n < 10);

    }

    public static void avaliaExpressao(List<Integer> list, Predicate<Integer> predicate) {
        list.forEach(n -> {
            if(predicate.test(n)){
                System.out.println(n + "");
            }
        });
    }
}
