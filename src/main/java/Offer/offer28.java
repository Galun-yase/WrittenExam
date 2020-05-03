package Offer;

import java.util.HashMap;
import java.util.Map;

public class offer28 {
    public int MoreThanHalfNum_Solution(int [] array) {

        if (array.length==0)return 0;
        int half=array.length/2;

        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])){
                map.put(array[i],1);
            }else {
                map.replace(array[i],map.get(array[i]),map.get(array[i])+1);
            }
        }
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if (entry.getValue()>half){
                return entry.getKey();
            }
        }
        return 0;
    }
}
