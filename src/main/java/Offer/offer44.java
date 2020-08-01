package Offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class offer44 {
    public String ReverseSentence(String str) {

        if (str== null || str.isEmpty() || str.matches("\\s+"))return str;

        String[] s = str.replaceAll("\\s+"," ").split(" ");
        StringBuilder sb = new StringBuilder();
        List<String> strings = Arrays.asList(s);
        Collections.reverse(strings);
        for (String sss:strings) {
            sb.append(sss).append(" ");
        }
        return sb.toString().trim();

    }
}
