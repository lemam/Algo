package Baekjoon;

import java.io.*;

public class BOJ_2138_전구와_스위치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());        // 전구의 개수
        char[] initial = br.readLine().toCharArray();   // 초기 상태
        char[] result = br.readLine().toCharArray();    // 목표 상태
        int answer = Integer.MAX_VALUE;                 // 최소 조작 횟수

        // 첫 번째 전구를 누르는 경우
        answer = Math.min(answer, trySwitch(true, initial, result));

        // 첫 번째 전구를 누르지 않는 경우
        answer = Math.min(answer, trySwitch(false, initial, result));

        // 출력
        if (answer == Integer.MAX_VALUE)
            System.out.println(-1);         // 불가능한 경우 -1을 출력
        else
            System.out.println(answer);

        br.close();
    }

    private static int trySwitch(boolean clickFirst, char[] initial, char[] result) {
        char[] arr = initial.clone();
        int count = 0;  // 조작 횟수

        // 첫 번째 전구를 누르는 경우
        if (clickFirst) {
            count = 1;
            toggle(arr, 0);
        }

        // 두 번째 전구부터 그리디하게 진행
        for (int i = 1; i < arr.length; i++) {
            // 이전 전구 상태(i-1)가 목표 상태와 다른 경우
            if (arr[i - 1] != result[i - 1]) {
                // 현재 전구 위치에서 스위치를 누른다.
                toggle(arr, i);
                count++;
            }
        }

        // 목표 상태와 같은지 확인
        boolean isPossible = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != result[i]) {
                isPossible = false;
                break;
            }
        }

        // 같다면 조작 횟수를 반환
        if (isPossible) return count;

        // 아니라면 최댓값 반환
        return Integer.MAX_VALUE;
    }

    private static void toggle(char[] arr, int idx) {
        // idx
        arr[idx] = arr[idx] == '0' ? '1' : '0';

        // idx - 1
        if (idx > 0)
            arr[idx - 1] = arr[idx - 1] == '0' ? '1' : '0';

        // idx + 1
        if (idx < arr.length - 1)
            arr[idx + 1] = arr[idx + 1] == '0' ? '1' : '0';
    }
}
