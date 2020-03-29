package Sort;

public class InsertSort {
    //直接插入排序 时间复杂度O(n2) 空间复杂度O(1)
    public static void starightInsertSort(int[] seqList){
        for (int i=1;i<seqList.length;i++){
            for (int j = i-1; j >=0 && seqList[j+1]<seqList[j]; j--) {
                swap(seqList,j,j+1);
            }
        }

    }

    //希尔排序(内含直接插入排序) 时间复杂度较直插小，无法精确计算
    public static void shellSort(int[] seqList){
        for (int step=seqList.length/2;step>0;step/=2){
            for (int i=0;i<step;i++){
                for (int j=i+step;j<seqList.length;j+=step){
                    for (int k=j-step;k>=0 && seqList[k+step]<seqList[k];k-=step){
                        swap(seqList,k+step,k);
                    }
                }
            }
        }
    }

    //交换元素位置
    private static void swap(int[] seqList,int index1,int index2){
        int temp=seqList[index1];
        seqList[index1]=seqList[index2];
        seqList[index2]=temp;
    }
}
