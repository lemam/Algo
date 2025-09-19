package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2504_괄호의_값 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] inputs = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();

        int answer = 0;
        int temp = 1;

        for (int i = 0; i < inputs.length; i++) {
            char curr = inputs[i];

            // 여는 괄호인 경우
            // 스택에 넣고 괄호열 값을 temp에 곱한다.
            if (curr == '(' || curr == '[') {
                stack.push(curr);
                temp *= curr == '(' ? 2 : 3;
                continue;
            }
            if (stack.isEmpty()) {
                answer = 0;
                break;
            }

            // 닫는 괄호인 경우
            char prev = stack.pop();

            // 현재 괄호가 ) 인 경우
            if (curr == ')') {
                // 올바른 괄호인지 확인
                if (prev != '(') {  // 아니라면
                    answer = 0;
                    break;
                } else {
                    // 이전 문자열이 여는 괄호이면 temp 값을 answer에 더해준다.
                    if (inputs[i - 1] == '(')
                        answer += temp;
                    temp /= 2;  // 사용한 괄호열 값 삭제
                }
                continue;
            }

            // 현재 괄호가 ] 인 경우
            if (curr == ']') {
                // 올바른 괄호인지 확인
                if (prev != '[') {  // 아니라면
                    answer = 0;
                    break;
                } else {
                    // 이전 문자열이 여는 괄호이면 temp 값을 answer에 더해준다.
                    if (inputs[i - 1] == '[')
                        answer += temp;
                    temp /= 3;  // 사용한 괄호열 값 삭제
                }
            }
        }

        // 스택에 괄호가 남아 있으면 올바른 괄호열 아님
        if (!stack.isEmpty()) answer = 0;

        // 출력
        System.out.println(answer);

        br.close();
    }
}
