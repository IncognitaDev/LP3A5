import java.util.Arrays;
import java.util.List;

public class ex1 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);

        for(Integer n: list) {
            System.out.println(n);
        }
        //same as ^
        list.forEach((n) -> System.out.println(n));
        //same as ^
        list.forEach(System.out::println);
    }

}
