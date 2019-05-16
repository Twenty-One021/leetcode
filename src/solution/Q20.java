package solution;

import java.util.Stack;

/**
 * @ClassName Q20
 * @Description
 * @Author zhihui
 * @Date 2019/3/22 17:44
 * @Version 1.0
 */
public class Q20 {
    public static void main(String[] args) {
        String s = "(]";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        boolean valid = true;
        if (s == null || s.length() % 2 != 0)
            return false;
        if (s.length() == 0)
            return true;
        String left = s.replaceAll("[)\\]}]", "");
        String right = s.replaceAll("[(\\[{]", "");
        if (left.length() != right.length()) {
            return false;
        }
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ("([{".indexOf(s.charAt(i)) != -1) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if (stack.isEmpty()) return false;
                String pop = stack.pop();
                valid = pop.replace("(", ")").replace("[", "]").replace("{", "}").charAt(0) == s.charAt(i);
                if (!valid) break;
            }
        }
        return valid;
    }

}
