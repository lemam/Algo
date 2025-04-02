package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_9935_문자열_폭발 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();

        char trigger = bomb.charAt(bomb.length() - 1);
        int bombSize = bomb.length();

        for (char ch : str.toCharArray()) {
            // 문자를 스택에 넣는다.
            stack.push(ch);

            // 폭발 문자의 마지막 문자가 스택에 들어온 경우
            if (stack.size() >= bombSize && ch == trigger) {
                boolean isBomb = true;

                // 폭발 문자열 길이만큼 스택에서 확인하기
                for (int i = 0; i < bombSize; i++) {
                    if (stack.get(stack.size() - bomb.length() + i) != bomb.charAt(i)) {
                        isBomb = false;
                        break;
                    }
                }

                // 폭발 문자열이 맞다면 스택에서 꺼낸다.
                if (isBomb) {
                    for (int i = 0; i < bomb.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        // 출력
        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char ch : stack) sb.append(ch);
            System.out.println(sb);
        }

        br.close();
    }
}
