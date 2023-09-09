package LeetcodeAndOffer.Leetcode;

import java.util.HashSet;
import java.util.Map;

public class LC874 {
    public int robotSim(int[] commands, int[][] obstacles) {
        //  0
        // 3  1
        //  2
        int direct = 0;
        int[][] dxy = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            set.add(obstacles[i][0] + "," + obstacles[i][1]);
        }

        int x = 0, y = 0;
        int res = 0;

        for (int i = 0; i < commands.length; i++) {
            int command = commands[i];

            if (command == -1) {
                direct = direct == 3 ? 0 : direct + 1;
            } else if (command == -2) {
                direct = direct == 0 ? 3 : direct - 1;
            } else {
                int[] d = dxy[direct];

                while (command > 0 && !set.contains((x + d[0]) + "," + (y + d[1]))) {
                    command--;
                    x = x + d[0];
                    y = y + d[1];
                }

                res = Math.max(res, x * x + y * y);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] commands = {4, -1, 4, -2, 4};
        int[][] ints = {{2, 4}};
        int i = new LC874().robotSim(commands, ints);
    }
}
