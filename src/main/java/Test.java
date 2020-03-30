import javax.management.Query;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Test {


    public static void  heapSort(int[] seqList){

        //构建大顶堆
        for (int i = seqList.length/2-1; i >=0 ; i--) {
            adjustHeap(seqList,i,seqList.length);
        }

        //调整大顶堆
        for (int i = seqList.length-1; i >=0 ; i--) {

            swap(seqList,0,i);
            adjustHeap(seqList,0,i);

        }

    }



    private static void adjustHeap(int[] seqList,int i,int length){
        int temp=seqList[i];

        for (int k = i*2+1; k < length; k=k*2+1) {//从最后一个非子节点开始
            if (k+1<length && seqList[k]<seqList[k+1]){//左节点小于右节点，则指向右节点
                k++;
            }
            if (seqList[k]>temp){
                seqList[i]=seqList[k];
                i=k;
            }else{
                break;
            }
        }
        seqList[i]=temp;



    }

    private static void swap(int[] seqList,int index1,int index2){
        int temp=seqList[index1];
        seqList[index1]=seqList[index2];
        seqList[index2]=temp;
    }



    public static void main(String[] args){
        int[] b={2,3,4,5,2,3,5};
        Test.heapSort(b);

        System.out.println(Arrays.toString(b));



    }
}
