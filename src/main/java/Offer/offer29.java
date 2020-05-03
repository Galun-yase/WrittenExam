package Offer;

public class offer29 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max=array[0];
        int res=array[0];
        for (int i = 1; i < array.length; i++) {
            max=Math.max(max+array[i],array[i]);
            res=Math.max(max,res);
        }
        return res;

    }
}
