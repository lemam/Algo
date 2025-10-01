package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9012_괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine()); // 테스트 케이스

        for (int tc = 1; tc <= T; tc++) {
            Stack<Character> stack = new Stack<>();
            char[] arr = br.readLine().toCharArray();
            String answer = "YES";

            for (int i = 0; i < arr.length; i++) {
                // '(' 일 경우 스택에 넣는다.
                if (arr[i] == '(') {
                    stack.push(arr[i]);
                    continue;
                }

                // ')' 일 경우
                // 스택이 비었거나 top이 '('이 아니라면 올바른 괄호 문자열이 아니므로 중지한다.
                if (stack.isEmpty() || stack.peek() != '(') {
                    answer = "NO";
                    break;
                }

                // 스택의 top이 '('일 경우 pop()
                stack.pop();
            }

            // '('이 스택에 남아있다면 올바른 괄호 문자열이 아니다.
            if (!stack.isEmpty())
                answer = "NO";

            sb.append(answer).append("\n");
        }

        System.out.println(sb);

        br.close();
    }
}
