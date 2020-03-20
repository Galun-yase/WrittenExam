import java.util.Arrays;

public class Solution40 {

    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        int[] temp=new int[k];
        for (int i=0;i<k;i++){
            temp[i]=arr[i];
        }
        return temp;

    }

}
