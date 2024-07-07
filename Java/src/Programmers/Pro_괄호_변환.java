package Programmers;

import java.util.Stack;

public class Pro_괄호_변환 {
    public String solution(String p) {
        // 올바른 괄호 문자열이면 그대로 반환
        if (checkIsCorrect(p)) return p;

        // 올바른 괄호 문자열이 아니면 과정을 따라 변환한다.
        // 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환한다.
        if (p.isEmpty()) return "";

        // 2. 균형잡힌 괄호 문자열 u, v로 분리한다.
        int idx = divideIndex(p);
        String u = p.substring(0, idx + 1);
        String v = p.substring(idx + 1);

        // 3. u가 올바른 괄호 문자열이면 v에 대해 재귀하고 u에 이어 붙여 반환한다.
        if (checkIsCorrect(u)) {
            return u + solution(v);
        }
        // 4. u가 올바른 괄호 문자열이 아니라면
        else {
            // 4-1. 빈 문자열에 첫 번째 문자로 '('을 붙인다.
            String answer = "(";

            // 4-2. v에 대해 재귀하고 수행한 결과를 문자열에 이어 붙인다.
            answer += solution(v);

            // 4-3. ')'를 붙인다.
            answer += ")";

            // 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙인다.
            StringBuilder sb = new StringBuilder();

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') sb.append(')');
                else sb.append('(');
            }

            answer += sb.toString();

            return answer;
        }
    }

    private int divideIndex(String p) {
        int open = 0, close = 0;    // 여는 괄호, 닫는 괄호 개수

        for (int i = 0; i < p.length(); i++) {
            // 괄호 개수 세기
            if (p.charAt(i) == '(') open++;
            else close++;

            // 최소한의 균형잡힌 괄호 문자열을 찾으면 분리한다.
            if (open == close) return i;
        }

        return 0;
    }

    private boolean checkIsCorrect(String p) {
        Stack<String> stack = new Stack<>();
        String[] arr = p.split("");

        // 여는 괄호이면 스택에 푸시한다. 닫는 괄호이면 스택에서 팝한다.
        for (String str : arr) {
            if (str.equals("(")) stack.push(str);
            else {
                // 스택이 비어있으면 짝이 맞지 않다는 뜻이므로 false를 반환한다.
                if (stack.isEmpty()) return false;
                else stack.pop();
            }
        }

        // 모든 괄호의 짝이 맞으면 스택은 비어있을 것이다.
        return stack.isEmpty();
    }
}
