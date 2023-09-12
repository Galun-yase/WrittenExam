package Sort;

import java.util.Arrays;

public class MergeSort {

    //归并排序 时间复杂度O(nlogn) 空间复杂度O(n)
    public static void mergeSort(int[] seqList,int left,int right){
        if (seqList==null){
            return;
        }
        if (left<right){
            int mid=(left+right)/2;
            mergeSort(seqList,left,mid);
            mergeSort(seqList,mid+1,right);
            merge(seqList,left,mid,right);
        }
    }
    //将两个有序表合并为一个表
    private static void merge(int[] seqList,int left,int mid,int right){
        int[] tempList=new int[seqList.length];
        int i=left;        //左序列指针
        int j=mid+1;       //右序列指针
        int t=0;        //临时序列指针

        while (i<=mid && j<=right){
            if (seqList[i]<=seqList[j]){
                tempList[t++]=seqList[i++];
            }else {
                tempList[t++]=seqList[j++];
            }
        }
        while (i<=mid){
            tempList[t++]=seqList[i++];
        }
        while (j<=right){
            tempList[t++]=seqList[j++];
        }
        t=0;
        while (left<=right){
            seqList[left++]=tempList[t++];
        }

    }

    private static void mergeSort_second(int[] seqList, int left, int right) {
        if (left >= right) return;

        int mid = (left + right) / 2;
        mergeSort_second(seqList, left, mid);
        mergeSort_second(seqList, mid + 1, right);
        mergeTwoArray(seqList, left, mid, right);
    }

    private static void mergeTwoArray(int[] seqList, int start, int mid, int end) {
        int[] tmp = new int[seqList.length];
        int left = start;
        int right = mid + 1;
        int index = 0;

        while (left <= mid && right <= end) {
            if (seqList[left] <= seqList[right]) {
                tmp[index] = seqList[left];
                left++;
            } else {
                tmp[index] = seqList[right];
                right++;
            }
            index++;
        }

        while (left <= mid) {
            tmp[index] = seqList[left];
            index++;
            left++;
        }

        while (right <= end) {
            tmp[index] = seqList[right];
            index++;
            right++;
        }

        // 临时数组从第一个元素开始存储
        index = 0;
        while (start <= end) {
            seqList[start++] = tmp[index++];
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 6, 7, 4, 2, 3, 8, 4, 8, 2};
        //quickSort_second(arr,0, arr.length-1);
        mergeSort_second(arr, 0, arr.length - 1);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
