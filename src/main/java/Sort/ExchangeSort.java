package Sort;

import java.util.Arrays;

public class ExchangeSort {

    //冒泡排序 时间复杂度O(n2) 空间复杂度O(1)
    public static void bubbleSort(int[] seqList){
        for (int i=0;i<seqList.length;i++){
            boolean flag=true;
            for (int j=0;j<seqList.length-1-i;j++){
                if (seqList[j]>seqList[j+1]){
                    swap(seqList,j,j+1);
                    flag=false;
                }
            }
            if (flag){break;}
        }
    }

    //快速排序 时间复杂度O(nlog2n)-O(n2) 空间复杂度O(log2n)-O(n)
    public static void quickSort(int[] seqList,int left,int right){
        if (left<right){
            int middle_index=partition(seqList,left,right);
            quickSort(seqList,left,middle_index-1);
            quickSort(seqList,middle_index+1,right);
        }

    }

    //快排中用于返回基准数的位置，并且使左边小于基准数，右边大于基准数
    private static int partition(int[] seqList,int first,int last){
        int pivotkey=seqList[first];
        while (first<last){
            while (first<last && seqList[last]>=pivotkey){
                last-=1;
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

    //交换元素位置
    private static void swap(int[] seqList,int index1,int index2){
        int temp=seqList[index1];
        seqList[index1]=seqList[index2];
        seqList[index2]=temp;
    }

    private static void bubbleSort_second(int[] seqList) {
        for (int i = 0; i < seqList.length; i++) {
            boolean flag = true;
            for (int j = 0; j < seqList.length - 1 - i; j++) {
                if (seqList[j] > seqList[j + 1]) {
                    swap(seqList, j, j + 1);
                    flag = false;
                }
            }
            if (flag) break;
        }
    }

    private static void quickSort_second(int[] seqList, int left, int right) {
        if (left >= right) return;

        int mid = partition_second(seqList, left, right);
        quickSort(seqList, left, mid - 1);
        quickSort(seqList, mid + 1, right);
    }

    private static int partition_second(int[] seqList, int left, int right) {
        int pivot = seqList[left];

        while (left < right) {
            while (left < right && pivot <= seqList[right]) {
                right--;
            }
            seqList[left] = seqList[right];

            while (left < right && seqList[left] <= pivot) {
                left++;
            }
            seqList[right] = seqList[left];
        }
        seqList[left] = pivot;
        // seqList[right]=pivot;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 7, 4, 2, 3, 8, 4, 8, 2};
        //quickSort_second(arr,0, arr.length-1);
        bubbleSort_second(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
