package LeetcodeAndOffer.Leetcode;

import com.sun.tools.internal.ws.wsdl.document.soap.SOAPUse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC51 {

    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        // 皇后可以攻击的范围，1
        int[][] attack = new int[n][n];
        // 皇后的位置
        char[][] queue = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(attack[i], 0);
            Arrays.fill(queue[i], '.');
        }

        // 回溯处理
        backtrace(0, n, attack, queue);

        return res;
    }

    /**
     * 回溯法处理
     *
     * @param k      当前要处理的行
     * @param n      需要放置多少个皇后，即棋盘 n * n
     * @param attack 表示皇后的攻击范围，1为可以攻击到，0为可以放置皇后
     * @param queue  皇后放置的位置
     */
    private void backtrace(int k, int n, int[][] attack, char[][] queue) {
        // 如果k==n,表示已经找到合适的结果
        if (k == n) {
            List<String> r = new ArrayList<>();
            for (char[] row : queue) {
                r.add(String.copyValueOf(row));
            }
            res.add(r);
            return;
        }

        // 正常处理第k行
        for (int i = 0; i < n; i++) {
            if (attack[k][i] == 0) {
                int[][] temp = new int[n][n];
                for (int j = 0; j < n; j++) {
                    for (int l = 0; l < n; l++) {
                        temp[j][l] = attack[j][l];
                    }
                }

                queue[k][i] = 'Q';

                checkQueueAttack(k, i, attack);
                backtrace(k + 1, n, attack, queue);

                // 回到之前的状态。queue至改变了一个值，故不需要临时变量
                attack = temp;
                queue[k][i] = '.';
            }

        }

    }

    /**
     * 皇后放置在(x,y)，更新攻击范围attack数组
     */
    private void checkQueueAttack(int x, int y, int[][] attack) {
        attack[x][y] = 1;

        // 表示八个方向
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 1; i < attack.length; i++) {
            for (int j = 0; j < 8; j++) {
                int nx = x + i * dx[j];
                int ny = y + i * dy[j];

                if (nx >= 0 && ny >= 0 && nx < attack.length && ny < attack[0].length) {
                    attack[nx][ny] = 1;
                }
            }
        }
    }

    public List<List<String>> solveNQueens_second(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] queue = new char[n][n];
        for (char[] q : queue) {
            Arrays.fill(q, '.');
        }

        boolean[][] attack = new boolean[n][n];
        for (boolean[] a : attack) {
            Arrays.fill(a, false);
        }

        backtrack_second(n, 0, attack, queue, res);

        return res;
    }

    private void backtrack_second(int n, int k, boolean[][] attack, char[][] queue, List<List<String>> res) {
        if (k == n) {
            ArrayList<String> list = new ArrayList<>();
            for (char[] q : queue) {
                list.add(String.copyValueOf(q));
            }
            res.add(list);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (attack[k][i]) continue;

            boolean[][] temp = new boolean[attack.length][attack[0].length];
            for (int j = 0; j < temp.length; j++) {
                for (int l = 0; l < temp[0].length; l++) {
                    temp[j][l] = attack[j][l];
                }
            }

            queue[k][i] = 'Q';
            updateAttack_second(attack, k, i);
            backtrack_second(n, k + 1, attack, queue, res);
            attack = temp;
            queue[k][i] = '.';
        }
    }

    private void updateAttack_second(boolean[][] attack, int x, int y) {
        attack[x][y] = true;

        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 1; i < attack.length; i++) {
            for (int j = 0; j < 8; j++) {
                int nx = x + i * dx[j];
                int ny = y + i * dy[j];

                if (nx >= 0 && ny >= 0 && nx < attack.length && ny < attack[0].length) {
                    attack[nx][ny] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        List<List<String>> lists = new LC51().solveNQueens(4);
        System.out.println(lists);
    }


}

// 官方题解
class Solution {

    // 保存所有符合要求的解
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        // attack 用来表示皇后的攻击范围
        int[][] attack = new int[n][n];
        // queen 用来记录皇后的位置
        char[][] queen = new char[n][n];

        // 初始化二维数组 queen 中所有的元素为 '.'
        for (char[] c : queen) {
            Arrays.fill(c, '.');
        }

        // 初始化二维数组 attack 中所有的元素为 0
        // 0 代表没有皇后能攻击得到
        // 1 代表出于任意一个皇后的攻击范围内
        for (int[] c : attack) {
            Arrays.fill(c, 0);
        }

        // 从棋盘的第 0 行第 0 列处理 n 皇后的情况
        backtrack(0, n, queen, attack);

        // 最后，返回所有符合要求的解
        return res;
    }

    // 很显然，每一行只能放置一个皇后，所以我们每一行每一行的来放置皇后
    // k 表示当前处理的行
    // n 表示需要放置多少个皇后，同时也代表棋盘的大小为 n * n
    // queen 用来记录皇后的位置
    // attack 用来表示皇后的攻击范围
    private void backtrack(int k, int n, char[][] queen, int[][] attack) {

        // 如果发现在棋盘的最后一行放置好了皇后，那么就说明找到了一组符合要求的解
        if (k == n) {
            // 由于 queen 为二维字符数组，所以需要转换为字符串数组
            List<String> list = new ArrayList<>();
            // 遍历二维数组 queen
            // 取出 queen 的每一行字符数组 c
            for (char[] c : queen) {
                // 把字符数组 c 中的所有字符转换为字符串的形式进行拼凑
                // 比如 ['.','Q','.','.',]
                // 转换为 '.Q..'
                // 把这个字符串加入到 list 中
                list.add(String.copyValueOf(c));
            }

            // list 即为一组符合要求的解，把它加入到结果数组中
            res.add(list);
            // 由于遍历完了所有的行，无需再遍历下去，所以返回
            return;
        }

        // 每一行只能放置一个皇后
        // 并且每一列也只能放置一个皇后
        // 所以在 k 行中，从 0 列到 n - 1 列，判断皇后应该放置到哪个位置
        for (int i = 0; i < n; i++) {
            // 如果发现 attack[k][i] == 0
            // 说明这个位置不在任何一个皇后的攻击范围内
            // 所以可以考虑放置皇后
            if (attack[k][i] == 0) {

                // 如果在 ( k , i ) 位置放置了皇后，那么就需要考虑在 k + 1 行应该怎么放置其它的皇后了
                // 由于有可能在( k , i )  位置放置了皇后之后，在后续的其它行会无法再放置其它的皇后
                // 那么就需要回到 ( k , i )  的状态，考虑能不能在 ( k , i + 1 )的位置放置
                // 为了能够回到 ( k , i )  的状态，所以需要先记录此时的 attack
                // 使用一个临时的二维数组，深度拷贝 attack
                // 如果不使用深度拷贝，而是直接使用 int[][] temp = c
                // 会导致 attack 发生改变是 temp 也会发生改变
                // 这样也就无法保存之前的状态了
                int[][] temp = new int[n][n];

                // 通过两个 for 循环，把 attack 中的所有元素深度拷贝到 temp
                for (int l = 0; l < n; l++) {
                    for (int m = 0; m < n; m++) {
                        temp[l][m] = attack[l][m];
                    }
                }

                // queen 用来记录皇后的位置
                // 那么 ( k , i )  的位置 queen[k][i] = 'Q'
                queen[k][i] = 'Q';

                // 由于新放置了一个皇后，所以攻击范围又更多了
                // 所以需要更新 attack 数组
                // 新放置皇后的坐标为 ( k , i ) ，同样的需要更新它的八个方向
                checkQueenAttack(k, i, attack);

                // 如果在 ( k , i )  位置放置了皇后，那么就需要考虑在 k + 1 行应该怎么放置其它的皇后
                // 递归的调用 backtrack 在 k + 1 行放置皇后
                backtrack(k + 1, n, queen, attack);

                // 递归结束后，拿走皇后，恢复 attack 的状态，考虑能不能在 ( k ,i + 1 )的位置放置
                attack = temp;

                // 恢复 queen 的状态，说明此时皇后不放置在( k , i )  位置
                queen[k][i] = '.';
            }
        }


    }

    // 坐标 ( x , y) 为皇后所处的位置
    // 更新 attack
    private void checkQueenAttack(int x, int y, int[][] attack) {

        // 对于每一个坐标 (x,y) 来说，都有上、下、左、右、左上、左下、右上、右下 八个方向
        //【左上】的坐标为 (x - 1, y - 1)
        //【上】的坐标为 (x - 1, y )
        //【右上】的坐标为 (x - 1, y + 1)
        //【左】的坐标为 (x, y + 1)
        //【右】的坐标为 (x , y - 1)
        //【左下】的坐标为 (x + 1, y - 1)
        //【下】的坐标为 (x + 1, y)
        //【右下】的坐标为 (x + 1, y + 1)
        // 通过两个一维数组可以表示这八个方向
        // dx 表示 x 的方向
        int dx[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        // dy 表示 y 的方向
        int dy[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        // 皇后所处的坐标肯定是皇后能攻击的位置，设置为 1
        attack[x][y] = 1;

        // 以坐标 ( x , y) 为中心，去更新它八个方向的坐标
        for (int j = 0; j < 8; j++) {
            // 由内向外的进行更新
            for (int i = 1; i < attack.length; i++) {
                // 新的位置的坐标行为 x + i * dx[j]
                int nx = x + i * dx[j];
                // 新的位置的坐标列为 y + i * dy[j]
                int ny = y + i * dy[j];

                // 如果新位置的坐标在 n * n 的棋盘范围内
                if (nx >= 0 && nx < attack.length && ny >= 0 && ny < attack.length) {
                    // 那么这些位置就是在坐标为 （x，y）的皇后的攻击范围内，更新为 1
                    attack[nx][ny] = 1;
                }

            }
        }
    }
}
