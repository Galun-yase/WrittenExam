package Exam;
import java.util.Scanner;

/**
 * @author 任青成
 * @date 2020/9/17 19:17
 */
public class Yitu2 {
    static int cos = 0;
    private static int mintime(int[][] map, int x, int y, int up, int down, int left, int right) {
        cos = Integer.MAX_VALUE;
        int[] z = {x,y,up,down,left,right};
        dfs(map,0,0,z,0);
        return cos==Integer.MAX_VALUE?-1:cos;
    }

    private static void dfs(int[][] map,int x,int y,int[] z,int costime){
        if (x==z[0] && y==z[1]){
            cos = Math.min(cos,costime);
            return;
        }
        map[x][y] = -1;
        if (ischeck(map,x+1,y) && map[x+1][y]!=-1)dfs(map,x+1,y,z,costime+z[3]);
        if (ischeck(map,x,y+1) && map[x][y+1]!=-1)dfs(map,x,y+1,z,costime+z[5]);
        if (ischeck(map,x-1,y) && map[x-1][y]!=-1)dfs(map,x-1,y,z,costime+z[2]);
        if (ischeck(map,x,y-1) && map[x][y-1]!=-1)dfs(map,x,y-1,z,costime+z[4]);
        map[x][y] = 0 ;
    }

    private static boolean ischeck(int[][] map ,int x,int y){
        return 0<=x && x < map.length && 0<=y && y<map[0].length;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < N; i++) {
            String[] nm = sc.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);//n行m列
            int m = Integer.parseInt(nm[1]);

            String[] xy = sc.nextLine().split(" ");
            int x = Integer.parseInt(xy[0]);//终点x,y
            int y = Integer.parseInt(xy[1]);

            String[] udlr = sc.nextLine().split(" ");
            int up = Integer.parseInt(udlr[0]);
            int down = Integer.parseInt(udlr[1]);
            int left = Integer.parseInt(udlr[2]);
            int right = Integer.parseInt(udlr[3]);
            int[][] map = new int[n][m];
            for (int j = 0; j < n-1; j++) {
                String str = sc.nextLine();
                for (int k = 0; k < m; k++) {
                    if (str.charAt(k)=='x'){
                        map[j][k] = -1;
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+mintime(map,x,y,up,down,left,right));
        }
        sc.close();
        }
}