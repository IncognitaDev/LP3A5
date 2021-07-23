package ex1;

public class Main {

    static double saldo = 500;

    public static void main(String[] args) {
        sacar(600d);
    }

    public static void sacar(double valor) {
        try {
            if(saldo < valor)
                throw new SaldoException();
            saldo -= valor;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
