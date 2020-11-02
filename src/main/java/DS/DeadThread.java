package DS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 任青成
 * @date 2020/10/11 23:01
 */
public class  DeadThread{
    public static void main(String[] args) {
        Lock lock1 = new ReentrantLock();
        Lock lock2 = new ReentrantLock();
        Thread t1 = new DeadThreadTest(lock1,lock2);
        Thread t2 = new DeadThreadTest(lock2,lock1);
        t1.start();
        t2.start();
    }
}
class DeadThreadTest extends Thread{

    Lock lock1;
    Lock lock2;

    public DeadThreadTest(Lock lock1,Lock lock2){
        this.lock1=lock1;
        this.lock2=lock2;
    }

    @Override
    public void run() {
        synchronized (lock1){
            try {
                Thread.sleep(5000);
                synchronized (lock2){

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
