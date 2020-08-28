package DS;

//单例模式一般有5种实现方式：饿汉式、懒汉式、双重检查、静态内部类、枚举。本题数据静态内部类来实现单例模式。
public class Singleton {

    //饿汉式（static表示在类加载的时候已经被初始化）
    private static Singleton instance=new Singleton();

    //私有构造方法
    private Singleton(){}
    //对外提供获取实例的静态方法
    public static Singleton getInstance(){
        return instance;
    }


}

//懒汉式（真正被使用的时候才初始化）
class Singleton2{

    private static Singleton2 instance;

    private Singleton2(){}

    private static Singleton2 getInstance(){
        if (instance==null){
            instance=new Singleton2();
        }
        return instance;
    }

}

//线程安全的懒汉式
class Singleton3{

    private static Singleton3 instance;

    private Singleton3(){};

    private static synchronized Singleton3 getInstance(){
        if (instance==null){
            instance=new Singleton3();
        }
        return instance;
    }
}

//线程安全的懒汉式(更高效，锁粒度小，双重校验锁)
class Singleton4{

    private static Singleton4 instance;
    private Singleton4(){};

    private static  Singleton4 getInstance(){

        if (instance==null){
            synchronized (Singleton4.class){
                if (instance==null){
                    instance=new Singleton4();
                }
            }
        }
        return instance;
    }


}

//序列化破坏
class Singleton5{

    private static Singleton5 instance;
    private Singleton5(){};

    private static  Singleton5 getInstance(){

        if (instance==null){
            synchronized (Singleton5.class){
                if (instance==null){
                    instance=new Singleton5();
                }
            }
        }
        return instance;
    }

    //防止序列化破坏
    private Object readResolve(){
        return instance;
    }

}

//枚举式
enum Singleton6{
    INSTANCE;
    Singleton6(){}
}
