import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * 1. ReadWriteLock : 读写锁
 *
 * 写写/读写 需要“互斥”
 * 读读 不需要互斥
 *
 */
public class Test {

    private static String a="s" ;

    public static void main(String[] args) {
        System.out.println(Test.a);

        Test test=new Test();
        System.out.println();

        System.out.println(test.a);

    }
}
