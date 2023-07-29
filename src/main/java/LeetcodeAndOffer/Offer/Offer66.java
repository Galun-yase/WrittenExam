package LeetcodeAndOffer.Offer;

public class Offer66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return new int[0];

        int[] pre = new int[a.length];
        int[] suf = new int[a.length];
        int[] res = new int[a.length];

        pre[0] = 1;
        suf[a.length - 1] = 1;

        for (int i = 1; i < a.length; i++) {
            pre[i] = pre[i - 1] * a[i - 1];

        }
        for (int i = a.length - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * a[i + 1];
        }

        for (int i = 0; i < a.length; i++) {
            res[i] = pre[i] * suf[i];
        }
        return res;
    }
}
