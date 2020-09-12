package Exam;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/12 21:14
 */
public class Wangy1 {
        private boolean iscondi(String str,int start,int end){
        HashSet<Character> set = new HashSet<>();
        set.add('a');set.add('b');set.add('c');
        set.add('x');set.add('y');set.add('z');
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = start; i <= end; i++) {
            if (set.contains(str.charAt(i))){
                if (map.containsKey(str.charAt(i))){
                    map.put(str.charAt(i),map.get(str.charAt(i))+1);
                }else {
                    map.put(str.charAt(i),1);
                }
            }
        }
        if (map.size()==0)return false;
        Collection<Integer> values = map.values();
        for (Integer tt:values) {
            if (tt%2!=0){
                return false;
            }
        }
        return true;
    }

    public int maxLenofCond(String str){
        int res = 1;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j >=0 ; j--) {
                if (iscondi(str,j,i)){
                    res = Math.max(res,i-j+1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            System.out.println(new Wangy1().maxLenofCond(str));
        }



    }
}
