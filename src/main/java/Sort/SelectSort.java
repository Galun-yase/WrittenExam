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
}
