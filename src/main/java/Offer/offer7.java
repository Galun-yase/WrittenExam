package Offer;

public class offer7 {
    public int Fibonacci(int n) {

        if (n==0)return 0;
        if (n==1 || n==2)return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);


    }
}
