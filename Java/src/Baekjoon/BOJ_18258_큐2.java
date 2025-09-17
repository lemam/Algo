package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_18258_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<Integer>();
        int N = Integer.parseInt(br.readLine()); // 명령의 수
        int last = 0; // 마지막에 넣은 수

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                // 정수 X를 큐에 넣는 연산이다.
                case "push":
                    int X = Integer.parseInt(input[1]);
                    queue.add(X);
                    last = X;
                    break;

                // 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.
                // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "pop":
                    if (!queue.isEmpty())
                        sb.append(queue.poll()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                // 큐에 들어있는 정수의 개수를 출력한다.
                case "size":
                    sb.append(queue.size()).append("\n");
                    break;

                // 큐가 비어있으면 1, 아니면 0을 출력한다.
                case "empty":
                    int result = queue.isEmpty() ? 1 : 0;
                    sb.append(result).append("\n");
                    break;

                // 큐의 가장 앞에 있는 정수를 출력한다.
                // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "front":
                    if (!queue.isEmpty())
                        sb.append(queue.peek()).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;

                // 큐의 가장 뒤에 있는 정수를 출력한다.
                // 만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
                case "back":
                    if (!queue.isEmpty())
                        sb.append(last).append("\n");
                    else
                        sb.append(-1).append("\n");
                    break;
                default:
                    break;
            }
        }

        System.out.println(sb);

        br.close();
    }
}