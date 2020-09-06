package DS;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author 任青成
 * @date 2020/8/31 0:13
 */
//生产者 消费者 阻塞队列实现
//其他方法需要实现一个阻塞队列即可(wait,notify)满或空的时候阻塞wait，完成加减后notify
public class ProducerCosumer {

    public static void main(String[] args) {

        BlockingQueue queue = new LinkedBlockingQueue(5);
        Thread pro = new Thread(new Producer(queue));
        Thread con = new Thread(new Consumer(queue));
        pro.start();
        con.start();
    }

}
class Producer implements Runnable{

    private final BlockingQueue proQueue;
    Producer(BlockingQueue queue){
        this.proQueue=queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try{
                System.out.println("生产者生产编号："+i);
                proQueue.put(i);
            }catch (Exception e){

            }
        }

    }
}
class Consumer implements Runnable{
    private final BlockingQueue conQueue;
    Consumer(BlockingQueue queue){
        this.conQueue=queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                  System.out.println("消费者消费编号："+conQueue.take());
            }catch (Exception e){

            }
    }
    }
}
