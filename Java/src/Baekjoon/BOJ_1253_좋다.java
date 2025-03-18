package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_1253_좋다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        // arr 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // arr 오름차순 정렬
        Arrays.sort(arr);

        // 몇 개의 숫자를 만들 수 있는지 탐색
        for (int i = 0; i < N; i++) {
            int start = 0;
            int end = N - 1;

            while (start < end) {
                int sum = arr[start] + arr[end];

                // 1. 두 수의 합이 arr[i]와 같은 경우
                if (sum == arr[i]) {
                    // 자기 자신을 사용한 경우 스킵한다.
                    if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    }
                    // 좋은 수의 개수를 추가한다.
                    else {
                        answer++;
                        break;
                    }
                }
                // 2. 두 수의 합이 arr[i]보다 작은 경우
                else if (sum < arr[i]) {
                    start++;
                }
                // 3. 두 수의 합이 arr[i]보다 큰 경우
                else {
                    end--;
                }
            }
        }

        System.out.println(answer);

        br.close();
    }
}