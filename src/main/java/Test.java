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


    public static void main(String[] args) {
        B b=new B();
        System.out.println(b.name);
        System.out.println(b.getName());


    }
}

class A{
     public String name="123";

     public String getName(){
         return name;
     }

}

class B extends A{

    public String name="bbb";
    public String getName(){
        return name;
    }
}