import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("digite a frase: ");

        String phrase = sc.nextLine();

        LetterCount lc = new LetterCount(phrase);

        Thread t = new Thread(lc);
        t.start();
    }

}
