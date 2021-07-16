import java.util.Scanner;

public class Main {
    static int  n1;
    static int n2;

    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        try{
            soma(io);
        }
        catch (ArithmeticException e) {
            System.out.println("o denomindador não pode ser 0");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            System.out.println("Execução finalizada");
        }
    }

    public static void soma(Scanner io) throws  ArithmeticException, NumberFormatException {
        System.out.println("digite o 1° numero");
        n1 = io.nextInt();
        if(n1 < 0){
            throw new NumberFormatException("Erro: argumento negativo");
        }else if (n1 > 1000) {
            throw new NumberFormatException("Erro: digite um valor menor que 1000");
        }
        System.out.println("digite o 2° numero");
        n2 = io.nextInt();
        if(n1 < 0){
            throw new NumberFormatException("Erro: argumento negativo");
        }else if (n1 > 1000) {
            throw new NumberFormatException("Erro: digite um valor menor que 1000");
        }

        int divisao  = n1 / n2;

        System.out.println("divisao: " + divisao);
    }
}
