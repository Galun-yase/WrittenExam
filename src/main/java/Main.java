import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{


    private static final Exchanger<String> ex = new Exchanger<>();
    private static ExecutorService threadpool = Executors.newFixedThreadPool(2);



    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);


        threadpool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    String exchange = Main.ex.exchange(A);
                    System.out.println("线程1 "+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        threadpool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B ="银行流水B";
                    String exchange = Main.ex.exchange(B);
                    System.out.println("线程2 "+exchange);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadpool.shutdown();
    }
}