package LeetcodeAndOffer.Leetcode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LC71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        Stack<String> stack = new Stack<>();

        for (String c : split) {
            if (Objects.equals(c, "..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            if (Objects.equals(c, ".")) {
                continue;
            }

            if (!Objects.equals(c, "")) {
                stack.push(c);
            }
        }

        return "/" + String.join("/", stack);
    }

    public static void main(String[] args) {
        Stack<String> strings = new Stack<>();
        strings.push("aa");
        String join = String.join("/", strings);
        System.out.println(join);
    }

    public String simplifyPath_2(String path) {
        Stack<String> stack = new Stack<>();
        String[] strings = path.split("/");

        for (String str : strings) {
            if (Objects.equals(str, ".") || Objects.equals(str, "")) {
                //do nothing
            } else if (Objects.equals(str, "..")) {
                if (stack.isEmpty()) continue;
                stack.pop();
            } else {
                stack.push(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        ArrayList<String> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append("/").append(list.get(i));
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}
