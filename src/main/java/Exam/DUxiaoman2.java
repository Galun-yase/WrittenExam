package Exam;

import java.util.Scanner;


/**
 * @author 任青成
 * @date 2020/9/20 20:42
 */
public class DUxiaoman2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int c = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < c; i++) {
                String[] s = scanner.nextLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int m = Integer.parseInt(s[0]);
                char[][] map = new char[n][m];
                for (int j = 0; j < n; j++) {
                    map[j] = scanner.nextLine().toCharArray();
                }
                System.out.println(min(map,n,m));
            }
        }
    }

    private static int min(char[][] map, int n, int m) {
        int[] findstart = findstart(map, n, m);
        int x = findstart[0];
        int y = findstart[1];

        dfs(map,x,y,0);
        return res;
    }
    private static int res = Integer.MAX_VALUE;
    private static void dfs(char[][] map, int x, int y, int count) {
        if ((!isIn(x, y, map) || map[x][y]=='#')){
            res = Math.min(count,res);
            return;
        }
        char temp = map[x][y];
        map[x][y]='#';
        if (isIn(x+1, y, map)){
            if (map[x+1][y]=='.'){
                dfs(map, x+1, y, count);

            }
            if (map[x+1][y]=='*'){
                dfs(map, x+1, y, count+1);
            }
        }
        if (isIn(x-1, y, map)){
            if (map[x-1][y]=='.'){
                dfs(map, x-1, y, count);

            }
            if (map[x-1][y]=='*'){
                dfs(map, x-1, y, count+1);
            }
        }
        if (isIn(x, y+1, map)){
            if (map[x][y+1]=='.'){
                dfs(map, x, y+1, count);

            }
            if (map[x][y+1]=='*'){
                dfs(map, x, y+1, count+1);
            }

        }
        if (isIn(x, y-1, map)){
            if (map[x][y-1]=='.'){
                dfs(map, x, y-1, count);

            }
            if (map[x][y-1]=='*'){
                dfs(map, x, y-1, count+1);
            }

        }
        map[x][y]=temp;
    }

    private static boolean isIn(int x,int y, char[][] map){
        int n = map.length;
        int m = map[0].length;
        return 0<=x && x<n && 0<=y && y<m;
    }


    private static int[] findstart(char[][] map,int n,int m){
        int[] res = new int[2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]=='@');{
                     res[0]=i;
                     res[1]=j;
                }
            }
        }
        return res;
    }

}
