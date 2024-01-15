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

    public int canCompleteCircuit_2(int[] gas, int[] cost) {
        int gasCount = 0;
        int costCount = 0;

        for (int i = 0; i < gas.length; i++) {
            gasCount += gas[i];
            costCount += cost[i];
        }
        if (costCount > gasCount) return -1;


        int index = 0;
        gasCount = 0;
        costCount = 0;
        for (int i = 0; i < gas.length; i++) {
            gasCount += gas[i];
            costCount += cost[i];

            if (costCount > gasCount) {
                gasCount = 0;
                costCount = 0;
                index = i + 1;
            }
        }
        return index;
    }
}
