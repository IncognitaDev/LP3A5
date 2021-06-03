import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Digite o primerio numero");
        int n1 = input.nextInt();
        System.out.println("Digite o segundo numero");
        int n2 = input.nextInt();
        System.out.println("Escolha a operação");
        System.out.println("0 - Soma");
        System.out.println("1 - Subtração");
        System.out.println("2 - Multiplicação");
        System.out.println("3 - Divisão");
        int opt = input.nextInt();

        Thread t1 = new Thread(new Calculator(n1,n2,opt));
        t1.start();
    }
}
