import javax.management.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test {

    public static void  quickSort(int[] seqList,int left,int right){
        if (left<right){
            int index_middle=partition(seqList,left,right);
            quickSort(seqList,left,index_middle-1);
            quickSort(seqList,index_middle+1,right);
        }
    }



    //寻找基准数的位置，并使数组左边小于这个基准数，右边大于这个基准数
    private static int partition(int[] seqList,int first,int last){
        int pivotkey=seqList[first];//基准数，最后返回他的位置
        while (first<last){
            while (first<last && seqList[last]>=pivotkey){
                last--;
            }
            seqList[first]=seqList[last];
            while (first<last && seqList[first]<=pivotkey){
                first++;
            }
            seqList[last]=seqList[first];
        }
        seqList[first]=pivotkey;
        return first;
    }



    public static void main(String[] args){
        int[] b={2,3,4,5,2,3,5};
        Test.quickSort(b,0,b.length-1);

        System.out.println(Arrays.toString(b));



    }
}
