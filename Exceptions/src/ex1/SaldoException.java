package ex1;

public class SaldoException extends RuntimeException {
    public SaldoException() {
        super("Salso insuficiente!");
    }
}
