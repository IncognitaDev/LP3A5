import java.util.stream.Stream;

public class Ex2 {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5).findFirst().ifPresent(System.out::println);
    }
}
