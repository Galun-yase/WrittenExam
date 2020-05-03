import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ByteDance1 {

    private static String sameThree(String s){
        Map<Character,Integer> map=new HashMap<>();
        for (char c:s.toCharArray()) {
            if (!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.replace(c,map.get(c),map.get(c)+1);
            }

        }

        for (Map.Entry<Character,Integer> entry:map.entrySet()) {
            if (entry.getValue()>=3){
                Character c=entry.getKey();
                s=s.replaceAll(""+c+c+"["+c+"]*",""+c+c);
            }
        }
        return s;


    }

    private static String trimAABB(String s){
        char[] c=s.toCharArray();
        List<Character> chars=new ArrayList<>();
        for (char cc:c) {
            chars.add(cc);
        }
        for (int i = 0; i < chars.size()-3; i++) {
            if (chars.get(i)==chars.get(i+1) && chars.get(i+2)==chars.get(i+3)){
                chars.remove(i+3);
            }
        }
        StringBuilder sb=new StringBuilder();
        for (char ccc:chars) {
            sb.append(ccc);
        }


        return sb.toString();
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String[] strs=new String[n];
        for (int i = 0; i < n; i++) {
            strs[i]=scanner.next();
        }
        for (String str:strs) {
            System.out.println(ByteDance1.trimAABB(ByteDance1.sameThree(str)));
        }

    }

}










