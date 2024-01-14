package LeetcodeAndOffer.Leetcode;

public class LC605 {

    // 优化版本，可以跳过某些值
    public boolean canPlaceFlowers(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; ) {

            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == flowerbed.length - 1 || flowerbed[i + 1] == 0) {
                i += 2;
                n--;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }


    public boolean canPlaceFlowers_self(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; i++) {

            int before = i - 1;
            int after = i + 1;

            if (flowerbed[i] == 1) continue;

            if ((before < 0 || flowerbed[before] == 0) && (after >= flowerbed.length || flowerbed[after] == 0)) {
                flowerbed[i] = 1;
                n--;
            }
        }
        return n <= 0;
    }

    public boolean canPlaceFlowers_second(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length; ) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i + 1 >= flowerbed.length || flowerbed[i + 1] == 0) {
                i += 2;
                n--;
            } else {
                i += 3;
            }
        }
        return n <= 0;
    }

    public boolean canPlaceFlowers_4(int[] flowerbed, int n) {

        for (int i = 0; i < flowerbed.length; ) {
            int f = flowerbed[i];

            if (f == 1) {
                i += 2;
            }

            if (i < flowerbed.length && flowerbed[i] == 0) {
                if (i + 1 >= flowerbed.length) return n == 0;
                if (flowerbed[i + 1] == 0) {
                    n--;
                    flowerbed[i]=1;
                }else {
                    i++;
                }
            }

        }
        return n == 0;
    }
}
