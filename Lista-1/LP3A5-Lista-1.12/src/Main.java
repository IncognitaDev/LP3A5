import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o primeiro numero");
        int x = input.nextInt();
        System.out.println("Digite o segundo numero");
        int z = input.nextInt();

        Thread t = new Thread(new Increment(x,z));
        t.start();

    }
}
