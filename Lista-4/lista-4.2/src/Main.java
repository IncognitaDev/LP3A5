import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<Integer> l = Arrays.asList(0,1,2,3,4,5,6,7,8,9);

        l.stream()
                .filter(n -> n % 2 == 0)
                .skip(2)
                .limit(2)
                .map(n -> n * 2)
                .forEach(System.out::println);
    }
}
