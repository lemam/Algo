package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2668_숫자고르기 {
    private static int[] arr;
    private static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());    // 정수의 개수
        arr = new int[N + 1]; // 표의 둘째 줄의 정수 배열
        result = new ArrayList<>();

        // arr 입력
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 순서대로 DFS 탐색을 진행하며 사이클이 발생하는지 확인한다.
        boolean[] visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i, visited);
            visited[i] = false;
        }

        // 오름차순으로 정렬
        Collections.sort(result);

        // 출력
        StringBuilder sb = new StringBuilder();

        sb.append(result.size()).append("\n");
        for (int num : result) {
            sb.append(num).append("\n");
        }

        System.out.println(sb);

        br.close();
    }

    private static void dfs(int idx, int target, boolean[] visited) {
        // 사이클이 발생하면 시작 숫자를 저장한다.
        if (arr[idx] == target) {
            result.add(target);
        }

        if (!visited[arr[idx]]) {
            visited[arr[idx]] = true;
            dfs(arr[idx], target, visited);
            visited[arr[idx]] = false;
        }
    }
}
