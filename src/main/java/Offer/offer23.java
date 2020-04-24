package Offer;

public class offer23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)return false;
        return verify(sequence,0,sequence.length-1);

    }


    public boolean verify(int[] array,int start,int end){

        if (start>=end)return true;
        for (int i = start; i <end ; i++) {
            if (array[i]>array[end]){
                for (int j = i; j < end; j++) {
                    if (array[j]<array[end]){
                        return false;
                    }
                }
                return verify(array,start,i-1) && verify(array,i,end-1);
            }
        }
        return verify(array,start,end-1);



    }

}
