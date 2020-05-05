import java.util.LinkedHashMap;
import java.util.Map;

public class Main{
    public int InversePairs(int [] array) {
        int count=0;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j]>array[i]){
                    count++;
                }
            }

        }
        return count%1000000007;

    }


    public static void main(String[] args) {
        Main main=new Main();
        int[] array={1,2,3,4,5,6,7,0};
        System.out.println(main.InversePairs(array));
    }
}