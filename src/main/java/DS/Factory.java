package DS;

/**
 * @author 任青成
 * @date 2020/9/4 14:14
 */
public class Factory {

    public static void main(String[] args) {
        //工厂方法：一个工厂生产一种产品
        IFactory factory = new FactoryMethod();
        IProduct prodect = factory.createProduct();
        prodect.productMethod();

//==========================================
        //抽象工厂：一个工厂生产一种产品族
        IFactory1 factory1 = new Factory1();
        factory1.createProduct1().show();
        factory1.createProduct2().show();
    }

}

//================》工厂方法：一个工厂生产一种产品
interface IProduct {
    public void productMethod();
}

class Product implements IProduct {
    public void productMethod() {
        System.out.println("产品");
    }
}

interface IFactory {
    public IProduct createProduct();
}

class FactoryMethod implements IFactory {
    public IProduct createProduct() {
        return new Product();
    }
}

//================》抽象工厂：一个工厂生产一种产品族
interface IProduct1 {
    public void show();
}
interface IProduct2 {
    public void show();
}

class Product1 implements IProduct1 {
    public void show() {
        System.out.println("这是1型产品");
    }
}
class Product2 implements IProduct2 {
    public void show() {
        System.out.println("这是2型产品");
    }
}
interface IFactory1 {
    public IProduct1 createProduct1();
    public IProduct2 createProduct2();
}
class Factory1 implements IFactory1{
    public IProduct1 createProduct1() {
        return new Product1();
    }
    public IProduct2 createProduct2() {
        return new Product2();
    }
}

