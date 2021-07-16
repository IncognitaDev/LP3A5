import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Leitor extends BufferedReader implements AutoCloseable {

    public Leitor(String fileName) throws FileNotFoundException {
        super(new FileReader(fileName));
    }
}
