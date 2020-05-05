package Offer;

import java.util.LinkedHashMap;
import java.util.Map;

public class offer33 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map=new LinkedHashMap<>();
        for (Character ch:str.toCharArray()) {
            if (!map.containsKey(ch)){
                map.put(ch,1);
            }else {
                map.replace(ch,map.get(ch)+1);
            }
        }
        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            if (entry.getValue()==1){
                return str.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
