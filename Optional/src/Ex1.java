import java.util.Optional;

public class Ex1 {
    public static void main(String[] args) {
        String numStr = "1";
//        String numStr = "um";

        Optional<Integer> num = toNum(numStr);
        System.out.println(num);

        System.out.println(num.isPresent());
        num.ifPresent(System.out::println);

    }
    public static Optional<Integer> toNum(String numStr) {
        try {
            return Optional.of(Integer.valueOf(numStr));
        }catch(Exception e) {
            return Optional.empty();
        }
    }
}
