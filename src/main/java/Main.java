import java.util.Arrays;
import java.util.Scanner;

class Main{


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int q = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            for (int i = 0; i < q; i++) {
                int x = sc.nextInt();
                int index = multi(arr,x,0,n-1);
                System.out.println(arr[index]);
            }
        }
    }

    private static int multi(int[] arr, int x,int start,int end) {
        int index = (start + end) / 2;
        if (start+1==end){
            int one = x - arr[start];
            int two = arr[end] - x;
            return one<=two?start:end;
        }
        if (arr[index]==x){
            return index;
        }else if (x<arr[index]){
            return multi(arr,x,start,index);
        } else {
            return multi(arr,x,index,end);
        }
    }

}