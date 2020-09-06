package DS;

//单例模式一般有5种实现方式：饿汉式、懒汉式、双重检查、静态内部类、枚举。本题数据静态内部类来实现单例模式。

//饿汉式（static表示在类加载的时候已经被初始化）
public class Singleton {
    private Singleton(){}
    private static Singleton instance=new Singleton();
    public static Singleton getInstance(){
        return instance;
    }
}

//懒汉式（真正被使用的时候才初始化）
class Singleton2{
    private Singleton2(){}
    private static Singleton2 instance=null;
    private static Singleton2 getInstance(){
        if (instance==null){
            instance=new Singleton2();
        }
        return instance;
    }

}

//线程安全的懒汉式
class Singleton3{

    private static volatile Singleton3 instance=null;
    private Singleton3(){};
    private static synchronized Singleton3 getInstance(){
        if (instance==null){
            instance=new Singleton3();
        }
        return instance;
    }
}

//双重校验锁
class Singleton4{

    private static volatile Singleton4 instance=null;
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

//静态内部类
class Singleton5{
    private static class Holder{
        private static Singleton5 instance = new Singleton5();
    }
    private Singleton5(){};
    public static Singleton5 getInstance(){
        return Holder.instance;
    }


}
//以上都有反射和反序列化破坏单例
//枚举式
enum Singleton6{
    INSTANCE;
    Singleton6(){};//私有
    //调用INSTANCE时会调用私有构造方法
}
