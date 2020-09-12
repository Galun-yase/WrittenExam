package Exam;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/12 21:15
 */
public class Wangy2 {
    public int has(int[] array,int root){
        if (array[root]==0)return 0;
        if (array[(2*root+1)*2+1]==0 && array[(2*root+1)*2+2]==0
                && array[(2*root+2)*2+1]==0 && array[(2*root+2)*2+2]==0)return 1;

        return has(array,2*root+1)+has(array,2*root+2);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int edeg = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();//<id,index>
        map.put(1,0);

        int[] list = new int[100];
        list[map.get(1)]=1;
        for (int i = 0; i < edeg; i++) {
            int id1 = scanner.nextInt();
            String str = scanner.next();
            int id2 = scanner.nextInt();

            if ("left".equals(str)){
                map.put(id2,2*map.get(id1)+1);
            }
            if ("right".equals(str)){
                map.put(id2,2*map.get(id1)+2);
            }
            list[map.get(id2)]=id2;
        }
        System.out.println(new Wangy2().has(list,0));
    }
}
