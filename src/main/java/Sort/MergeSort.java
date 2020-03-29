package Sort;

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
        int leftStart=left;
        int rightStart=mid+1;
        int tempIndex=left;

        while (leftStart<=mid && rightStart<=right){
            if (seqList[leftStart]<seqList[rightStart]){
                tempList[tempIndex++]=seqList[leftStart++];
            }else {
                tempList[tempIndex++]=seqList[rightStart++];
            }
        }
        while (leftStart<=mid){
            tempList[tempIndex++]=seqList[leftStart++];
        }
        while(rightStart<=right){
            tempList[tempIndex++]=seqList[rightStart++];
        }
        while(left<=right){
            seqList[left]=tempList[left++];
        }
    }
}
