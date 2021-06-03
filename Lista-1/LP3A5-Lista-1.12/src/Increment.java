import java.util.ArrayList;

public class Increment implements Runnable{
    private int x;
    private int y;

    public Increment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        ArrayList<Integer> steps = new ArrayList<Integer>();
        int v = this.x;
        int total =0;

        for (;total < this.y; v++){
            steps.add(v);
            total += v;
        }

        System.out.print(this.x + " " + this.y + " " + steps.size() + "(");
        printStack(steps);
        System.out.print( total + ")");
    }

    public void printStack(ArrayList<Integer> steps) {
        steps.forEach(x-> {
            System.out.print(x);
            if (steps.indexOf(x) == steps.size() - 1 ){
                System.out.print("=");
            }else {
                System.out.print("+");
            }
        });
    }
}
