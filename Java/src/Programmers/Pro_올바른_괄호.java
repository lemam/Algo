package Programmers;

import java.util.*;

class Pro_올바른_괄호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] inputs = s.toCharArray();

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        return stack.isEmpty();
    }
}
