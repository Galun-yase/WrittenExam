package LeetcodeAndOffer.Offer.ArraysAndMatrices;

public class Offer05 {

    public String replaceSpace(String s) {

        int length = s.length();

        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == ' ')
                sb.append("  ");
        }


        int P1 = length - 1;
        int P2 = sb.length() - 1;
        while (P1 >= 0) {
            char c = sb.charAt(P1);
            if (c == ' ') {
                sb.setCharAt(P2--, '0');
                sb.setCharAt(P2--, '2');
                sb.setCharAt(P2--, '%');
            } else {
                sb.setCharAt(P2--, c);
            }
            P1--;
        }
        return sb.toString();
    }

}
