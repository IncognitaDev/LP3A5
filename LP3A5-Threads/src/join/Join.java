package join;

public class Join {
    public static void main(String[] args) {
        Thread z = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<6; i++){
                    System.out.println("Tread z - contador" + 1);
                }
            }
        });

        Thread y = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    z.join();
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
                for (int i=0; i<6; i++){
                    System.out.println("Tread z - contador" + 1);
                }
            }
        });
    }
}
