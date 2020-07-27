package Offer;

/*
不太会
 */
public class offer34 {
    private int res = 0 ; //记录统计结果
    public int InversePairs(int [] array) {
        Merge_Array(array,0,array.length-1);
        return res ;
    }
    public void Merge_Array(int[] array,int origin,int end){
        if (origin>=end){ //只有一个值吗，不再进行归并
            return;
        }
        int mid = (origin + end) / 2 ;
        //左归并
        Merge_Array(array,origin,mid);
        //右归并
        Merge_Array(array,mid+1,end);
        // 排序统计
        Merge(array,origin,end,mid);

    }

    public void Merge(int[] array,int orgin,int end,int mid){
        int[] temp = new int[end-orgin+1] ; //辅助数组
        int i = 0 ; //temp数组添加新结果，向后移动
        int p1 = orgin ; // 左边数组的起点
        int p2 = mid+1 ; // 右边数组的起点
        // p1 , p2 比较哪个小把哪个放到temp
        while (p1<=mid && p2 <=end){
            if (array[p1]<=array[p2]){
                temp[i++] = array[p1++] ;
            }else {
                temp[i++] = array[p2++] ;
                this.res = (this.res + mid - p1 + 1) % 1000000007;
            }
        }
        if (p1>mid){  //说明左边全部添加到temp中，继续添加右边
            while (p2<=end){
                temp[i++] = array[p2++] ;
            }
        }
        if (p2>end){ //说明右边全部添加到temp中，继续添加左边
            while (p1<=mid){
                temp[i++] = array[p1++] ;
            }
        }
        //在原数组中用有序的值覆盖掉原来无序的值
        for (int j=0;j<temp.length;j++){
            array[orgin+j] = temp[j] ;
        }
    }


}
