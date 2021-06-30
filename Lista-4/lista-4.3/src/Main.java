import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        Stream.generate(new Random()::nextInt)
                .limit(100).forEach(System.out::println);

       List<Integer> l = Stream.generate(new Random()::nextInt).limit(10).toList();
       Optional<Integer> min = l.stream().min(Integer::compareTo);
       Optional<Integer> max = l.stream().max(Integer::compareTo);
       long count = l.stream().count();

       System.out.println("min: " + min + "\nmax: " + max + "\ntotal: "+ count);
    }
}
