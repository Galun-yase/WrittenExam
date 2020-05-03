import java.util.Scanner;

public class ByteDance7 {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]=scanner.nextInt();
        }
        int flag=0;
        for (int i = n-1; i >=0 ; i--) {
            flag=(array[i]+flag+1)/2;
        }
        System.out.println(flag);


    }
}
