import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Avaliacao> avList = new ArrayList<>();

        Thread t = new Thread(() -> {
            Avaliacao av = new Avaliacao("LP3A5", "Paulo", 10);
            Avaliacao av1 = new Avaliacao("LP3A5", "Luis", 10);
            Avaliacao av2 = new Avaliacao("LP3A5", "Carol", 10);
            avList.add(av);
            avList.add(av2);
            avList.add(av1);
        });
        t.start();
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        avList.sort((a1,a2) -> a1.getAluno().compareTo(a2.getAluno()));
        avList.forEach( a -> System.out.println(a.getAluno()));
    }

}
