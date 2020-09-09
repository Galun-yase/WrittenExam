package Offer;

public class offer23 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence.length==0)return false;
        return verify1(sequence,0,sequence.length-1);
    }

    private boolean verify1(int[] sequence, int start, int end) {
        if (start>=end)return true;
        for (int i = start; i < end; i++) {
            if (sequence[i]>sequence[end]){
                for (int j = i+1; j < end; j++) {
                    if (sequence[j]<sequence[end])return false;
                }
                return verify1(sequence,start,i-1) && verify1(sequence,i,end-1);
            }
        }
        return verify1(sequence,start,end-1);
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
