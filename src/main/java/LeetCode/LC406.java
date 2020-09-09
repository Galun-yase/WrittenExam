package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author 任青成
 * @date 2020/9/7 13:05
 */
//根据身高重建队列
public class LC406 {

    /**
     * description:
     * 输入:
     * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
     *
     * 输出:
     * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
     */
    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]>o2[0]){
                    return -1;
                }else if (o1[0]<o2[0]){
                    return 1;
                }else {
                    return o1[1]-o2[1];
                }

            }
        });
        ArrayList<int[]> list = new ArrayList<>(people.length);
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1],people[i]);
        }
        return list.toArray(new int[list.size()][2]);

    }

    public static void main(String[] args) {
        int[][] a = {{7,1},{7,0},{5,0},{6,1},{4,4},{5,2}};

        int[][] ints = new LC406().reconstructQueue(a);

        System.out.println(Arrays.toString(ints));
    }


}
