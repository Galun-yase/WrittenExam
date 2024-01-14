package LeetcodeAndOffer.Leetcode;

public class LC860 {

    // 暴力解法
    public boolean lemonadeChange(int[] bills) {
        int[] pay = new int[]{0, 0, 0};
        for (int b : bills) {
            if (b == 5) {
                pay[0]++;
            } else if (b == 10) {
                if (pay[0] == 0) return false;
                pay[0]--;
                pay[1]++;
            } else {
                if (pay[1] == 0 && pay[0] < 3) return false;
                if (pay[1] >= 1 && pay[0] == 0) return false;
                if (pay[1] == 0) {
                    pay[0] -= 3;
                } else {
                    pay[0]--;
                    pay[1]--;
                }
                pay[2]++;
            }
        }
        return true;
    }

    public boolean lemonadeChange_second(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                ten++;
                five--;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                    continue;
                }

                if (five >= 3) {
                    five -= 3;
                    continue;
                }
                return false;
            }
        }
        return true;
    }

    public boolean lemonadeChange_3(int[] bills) {

        int five = 0;
        int ten = 0;

        for (int i = 0; i < bills.length; i++) {
            int bill = bills[i];

            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else {
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
