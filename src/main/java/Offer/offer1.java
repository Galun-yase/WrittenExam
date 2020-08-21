package Offer;

public class offer1 {


    public boolean Find(int target, int [][] array) {
        if (array.length<=0||array[0].length<=0)return false;
        int row = array.length-1;
        int lindex = array[0].length-1;
        int rindex = 0;
        while (lindex>=0 && rindex<=row){
            if (array[rindex][lindex]==target)return true;
            else if (target<array[rindex][lindex])lindex--;
            else if (target>array[rindex][lindex])rindex++;
        }
        return false;
    }


//    public  int BinarySearch(int[] seqList,int key){
//        int begin=0;
//        int end=seqList.length-1;
//        int mid;
//        while (begin<=end){
//            mid=(begin+end)/2;
//            if (seqList[mid]==key){
//                return mid;
//            }else if (key<seqList[mid]){
//                end=mid-1;
//            }else {
//                begin=mid+1;
//            }
//        }
//        return -1;
//    }



    public int BS(int[] array, int key){
        if (array==null||array.length<=0)return -1;

        int start=0;
        int end=array.length-1;
        while (start<=end){
            int mid=(start+end)/2;
            if (array[mid]==key)return 1;
            else if (key<array[mid])end=mid-1;
            else if (key>array[mid])start=mid+1;
        }
        return -1;
    }

}
