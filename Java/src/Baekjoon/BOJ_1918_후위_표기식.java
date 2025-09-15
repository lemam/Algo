package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1918_후위_표기식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();   // 중위 표기식
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (char ch : inputs) {
            // 알파벳이면 문자열에 담는다.
            if (ch >= 'A' && ch <= 'Z') {
                sb.append(ch);
                continue;
            }

            // 여는 괄호이면 스택에 넣는다.
            if (ch == '(') {
                stack.push(ch);
                continue;
            }

            // 닫는 괄호이면 스택에서 여는 괄호가 나올 때까지
            if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    sb.append(stack.pop());
                }

                if (!stack.isEmpty()) stack.pop();  // '(' 삭제
                continue;
            }

            // +, -, *, / 연산자인 경우
            // stack에 있는 연산자가 현재 연산자보다 우선순위가 높으면 pop해서 문자열에 담는다.
            while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(ch)) {
                sb.append(stack.pop());
            }

            stack.push(ch); // 연산자를 스택에 넣는다.
        }

        // 스택에 남아 있는 연산자를 모두 꺼낸다.
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);

        br.close();
    }

    private static int precedence(char op) {
        if (op == '*' || op == '/') return 2;
        if (op == '+' || op == '-') return 1;
        return 0;
    }
}
