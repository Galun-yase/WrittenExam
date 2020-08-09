package Offer;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 任青成
 * @date 2020/8/9 15:23
 */
public class offer54 {

    private StringBuilder sb = new StringBuilder();
    private Map<Character,Integer> map = new HashMap<>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if (map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else {
            map.put(ch,1);
        }
        sb.append(ch);
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        char[] chars = sb.toString().toCharArray();
        for (char c:chars) {
            if (map.get(c)==1){
                return c;
            }
        }
        return '#';


    }

}
