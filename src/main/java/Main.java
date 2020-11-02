import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.TreeMap;

class Main{
    //输入：
    //[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
    //输出：
    //[[1,87],[2,88]]

    public TreeMap<Integer, PriorityQueue<Integer>> map = new TreeMap<>();

    public int[][] computTopkAvg(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            int[] idscore = arr[i];//[1,10]
            int id = idscore[0];
            int score = idscore[1];

            if (!map.containsKey(id)){
                PriorityQueue<Integer> minheap = new PriorityQueue<>(5);
                minheap.add(score);
                map.put(id,minheap);
            }else {
                PriorityQueue<Integer> minheap = map.get(id);
                if (minheap.size()<5){
                    minheap.add(score);
                }else {
                    Integer peek = minheap.peek();
                    if (peek<score){
                        minheap.remove(peek);
                        minheap.add(score);
                    }
                }
            }
        }

        //计算平均数
        int[][] result = computAvg();
        return result;

    }
    private  int[][] computAvg(){
        int[][] result = new int[map.size()][2];
        int k = 0;
        for (Map.Entry<Integer,PriorityQueue<Integer>> entry: map.entrySet()) {
            Integer id = entry.getKey();
            PriorityQueue<Integer> value = entry.getValue();
            int res = 0;
            int[] fivescore = new int[5];
            for (int i = 0; i < 5; i++) {
                fivescore[i] = value.poll();
            }
            for (int i:fivescore) {
                res+=i;
            }
            res = res/5;

            result[k][0] = id;
            result[k][1] = res;
            k++;
        }
        return result;
    }

    //输入：
    //[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
    //输出：
    //[[1,87],[2,88]]
    public static void main(String[] args) {
        int[][] arr = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
        Main main = new Main();
        int[][] ints = main.computTopkAvg(arr);
        for (int[] t:ints) {
            System.out.println(Arrays.toString(t));
        }
        System.out.println(Arrays.toString(ints));
    }


}