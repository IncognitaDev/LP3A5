import java.util.ArrayList;
import java.util.Arrays;

public class LetterCount implements Runnable{
    String phrase;

    public LetterCount(String phrase) {
        this.phrase = phrase;
    }

    @Override
    public void run() {
       String[] letters = phrase.replaceAll("[^\\p{L}]", "").split("");

       int total = (int) Arrays.stream(letters).count();
       int vowels = (int) Arrays.stream(letters).filter(a -> a.matches("[aeiou]")).count();
       int consonants = total - vowels;

       System.out.println(phrase + ", tem: " );
       if (vowels > 0) {
           System.out.println(vowels + " vogais ");
       }
       if (consonants  > 0) {
            System.out.println(consonants + " consoantes");
       }

    }
}
