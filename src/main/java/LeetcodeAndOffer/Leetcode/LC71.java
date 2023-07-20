package LeetcodeAndOffer.Leetcode;

import java.util.Objects;
import java.util.Stack;
import java.util.stream.Collectors;

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
}
