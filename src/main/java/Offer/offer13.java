package Offer;

public class offer13 {
    public void reOrderArray(int [] array) {

        int k=0;

        for (int i = 0; i < array.length; i++) {

            if (array[i]%2==1){

                int temp=array[i];
                int j=i;
                while (j>k){
                    array[j]=array[j-1];
                    j--;
                }
                array[k]=temp;
                k++;

            }

        }


    }
}
