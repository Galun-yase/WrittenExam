package Offer;
public class offer28 {
    //候选人法：找最多
    public int MoreThanHalfNum_Solution(int [] array) {
        int length=array.length;
        if(array==null||length<=0){
            return 0;
        }

        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times=1;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }

        times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
        }

        if (times * 2 >length) {
            return result;
        }
        return 0;
    }
}
