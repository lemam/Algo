package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_17266_어두운_굴다리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 굴다리 길이
        int M = Integer.parseInt(br.readLine());    // 가로등의 개수
        int[] posArr = new int[M];  // 가로등의 위치

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            posArr[i] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = N;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            // mid 높이로 모든 지점을 비출 수 있다면 result 갱신 후 높이를 줄여 재탐색
            if (isPossible(mid, N, posArr)) {
                result = mid;
                right = mid - 1;
            }
            // 모든 지점을 비출 수 없다면 높이를 높여 재탐색
            else {
                left = mid + 1;
            }
        }

        System.out.println(result);

        br.close();
    }

    private static boolean isPossible(int height, int N, int[] posArr) {
        // 이전 가로등이 비춘 마지막 지점
        // 0부터 모두 비춰야하기 때문에 0에서 시작한다.
        int prev = 0;

        for (int x : posArr) {
            // x - height : 가로등이 비추는 최소 지점
            // 최소 지점이 prev 이하이면 이전 지점을 포함하여 비춘다는 뜻이다.
            if (x - height <= prev) {
                prev = x + height;  // 가로등이 비추는 최대 지점을 prev에 저장한다.
            }
            // 만약 이전 가로등이 비춘 지점에 도달하지 못하면 모든 지점을 비출 수 없다.
            else {
                return false;
            }
        }

        // 마지막 지점도 가로등이 비출 수 있는지 확인한다.
        // 굴다리 끝 좌표 - 마지막 가로등의 최대 지점을 뺐을 때 0 이하면 마지막 지점에 도달했다는 뜻이다.
        return N - prev <= 0;
    }
}
