public class Calculator implements Runnable{

    private int num1;
    private int num2;
    private int opt;

    public Calculator(int num1, int num2, int opt){
        this.num1 = num1;
        this.num2 = num2;
        this.opt = opt;
    }

    @Override
    public void run() {
        switch (opt) {
            case 0 -> System.out.println(num1 + num2);
            case 1 -> System.out.println(num1 - num2);
            case 2 -> System.out.println(num1 * num2);
            case 3 -> System.out.println(num1 / num2);
        }
    }
}
