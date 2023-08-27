package Sort;

import java.util.Arrays;

public class  SelectSort {

    //直接选择排序 时间复杂度O(n2) 空间复杂度O(1)
    public static void starightSelectSort(int[] seqList){
        for (int i=0;i<seqList.length;i++){
            int min=seqList[i];
            int position=i;
            for (int j=i+1;j<seqList.length;j++){
                if (seqList[j]<min){
                    min=seqList[j];
                    position=j;
                }
            }
            seqList[position]=seqList[i];
            seqList[i]=min;
        }
    }

    //堆排序  时间复杂性O(nlogn) 空间复杂性O(1)
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

    //交换元素位置
    private static void swap(int[] seqList,int index1,int index2){
        int temp=seqList[index1];
        seqList[index1]=seqList[index2];
        seqList[index2]=temp;
    }

    private void heapSort_second(int[] arr) {
        // 先需要遍历构建大顶堆
        // 从最后一个非叶子节点从下至上调整
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap_second(arr, i, arr.length);
        }

        // 调整的时候，只需要从被交换的根节点调整
        for (int i = arr.length - 1; i > 0; i--) {
            swap_second(arr, 0, i);
            adjustHeap_second(arr, 0, i);
        }
    }

    private void adjustHeap_second(int[] arr, int parent, int length) {
        int tmp = arr[parent];
        int child = parent * 2 + 1;

        while (child < length) {
            if (child + 1 < length && arr[child] < arr[child + 1]) {
                child++;
            }

            // 此处构建大顶堆，小顶堆则parent小于左右节点最小值时，跳出循环
            if (tmp > arr[child]) break;

            arr[parent] = arr[child];
            parent = child;
            child = parent * 2 + 1;
        }
        arr[parent] = tmp;
    }

    private void swap_second(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,9,6,5,4,7,2,8};

        // 打印排序前的数组
        System.out.println(Arrays.toString(arr));

        // 执行堆排序操作
        new SelectSort().heapSort_second(arr);

        // 打印排序后的数组
        System.out.println(Arrays.toString(arr));
    }
}
