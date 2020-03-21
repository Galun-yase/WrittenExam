import java.lang.reflect.Array;

public class Test {
    public int maxAreaOfIsland(int[][] grid) {
        int res=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                res=Math.max(res,dfs(i,j,grid));
            }
        }
        return res;
    }
    private int dfs(int i,int j,int[][] grid){
        if(i<0 || j<0 || i>grid.length || j>grid[i].length || grid[i][j]==0){
            return 0;
        }
        int num=1;
        grid[i][j]=0;
        num+=dfs(i-1,j,grid);
        num+=dfs(i+1,j,grid);
        num+=dfs(i,j-1,grid);
        num+=dfs(i,j+1,grid);
        return num;
    }
    public static void main(String[] args){
        Object[] a=new Object[4];
        char[] aa={1,3};
        System.out.println();
    }
}
