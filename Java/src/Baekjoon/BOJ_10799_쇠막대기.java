package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10799_쇠막대기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int answer = 0;

        for (int i = 0; i < inputs.length; i++) {
            // 1. 열린 괄호이면 스택에 push하기
            if (inputs[i] == '(') {
                stack.push(inputs[i]);
            }
            // 2. 닫힌 괄호이면 스택을 pop하기
            else {
                stack.pop();

                // 이전 괄호과 열린 괄호이면 레이저를 뜻하므로
                // 레이저 왼쪽으로 쇠막대기 조각이 잘려지므로 answer에 스택 사이즈만큼 더한다.
                if (inputs[i - 1] == '(') {
                    answer += stack.size();
                }
                // 이전 괄호가 닫힌 괄호이면 잘린 쇠막대기 조각이 되므로 answer + 1을 한다.
                else {
                    answer++;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}