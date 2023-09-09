package LeetcodeAndOffer.Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC811 {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String cpdomain : cpdomains) {
            String[] split = cpdomain.split(" ");

            int times = Integer.parseInt(split[0]);
            String domain = split[1];

            while (domain.contains(".")) {
                hashMap.put(domain, hashMap.getOrDefault(domain, 0) + times);

                domain = domain.substring(domain.indexOf(".") + 1);
            }
            hashMap.put(domain, hashMap.getOrDefault(domain, 0) + times);

        }

        ArrayList<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }

    public static void main(String[] args) {
        String domain = "a.b.c";

        String substring = domain.substring(domain.indexOf(".") + 1);
        System.out.println(substring);
    }
}
