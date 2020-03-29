package Sort;

public class SelectSort {

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
    public static void heapSort(int[] seqList){
        for (int i=seqList.length/2-1;i>=0;i--){
            CreatHeap(seqList,i,seqList.length);
        }
        for (int i=seqList.length-1;i>0;i--) {
            swap(seqList,0,i);
            CreatHeap(seqList,0,i);
        }
    }

    //堆的构建过程
    private static void CreatHeap(int[] seqList,int i,int length){
        int temp=seqList[i];
        for (int j=2*i+1;j<length;j=j*2+1){//左子树开始
            if (j+1<length && seqList[j]<seqList[j+1]){//左子树小于右子树，则指向右子树
                j++;
            }
            if (seqList[j]>temp){
                seqList[i]=seqList[j];
                i=j;
            }else {
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
}
