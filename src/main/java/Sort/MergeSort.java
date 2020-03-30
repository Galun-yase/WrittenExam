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
}
