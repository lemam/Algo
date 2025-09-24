package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_10828_스택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":    // 정수 X를 스택에 넣기
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":     // 스택 가장 위에 있는 정수를 빼고 출력, 없으면 -1
                    if (!stack.empty()) sb.append(stack.pop()).append("\n");
                    else sb.append(-1).append("\n");
                    break;
                case "size":    // 스택에 들어있는 정수의 개수
                    sb.append(stack.size()).append("\n");
                    break;
                case "empty":   // 스택이 비어있으면 1, 아니면 0
                    if (!stack.empty()) sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
                case "top":     // 스택의 가장 위의 있는 정수 출력, 없으면 -1
                    if (!stack.empty()) sb.append(stack.peek()).append("\n");
                    else sb.append(-1).append("\n");
            }
        }

        System.out.println(sb);
    }
}
