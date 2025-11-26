package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1874_스택_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int start = 0;  // 스택에 넣을 수
        boolean flag = true;

        // n번 반복
        while (n-- > 0) {
            int num = Integer.parseInt(br.readLine());  // 현재 수열 원소

            // 지금까지 넣은 수의 최댓값이 num보다 작으면
            // num까지 오름차순으로 숫자 넣기
            if (num > start) {
                for (int i = start + 1; i <= num; i++) {
                    stack.push(i);
                    sb.append("+").append("\n");
                }

                start = num;
            }
            // 지금까지 넣은 수의 최댓값이 num 이상인데도
            // top에 있는 원소가 num과 다를 경우
            // 해당 수열은 만들 수 없음
            else if (stack.peek() != num) {
                System.out.println("NO");
                flag = false;
                break;
            }

            // 이제 top에 있는 원소가 num과 같으므로 pop한다.
            stack.pop();
            sb.append("-").append("\n");
        }

        if (flag) System.out.println(sb);

        br.close();
    }
}
