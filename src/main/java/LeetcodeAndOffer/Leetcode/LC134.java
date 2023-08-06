package LeetcodeAndOffer.Leetcode;

public class LC134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;

        int remainGas = 0;
        for (int i = 0; i < length; i++) {
            remainGas = remainGas + gas[i] - cost[i];
        }
        if (remainGas < 0) return -1;

        int currentGas = 0;
        int i = 0;
        int index = 0;

        while (i < length) {
            currentGas = currentGas + gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                index = i + 1;
                i++;
            } else {
                i++;
            }

        }
        return index;
    }
}
