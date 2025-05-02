package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2110_공유기_설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());   // 집의 개수
        int C = Integer.parseInt(st.nextToken());   // 공유기의 개수
        int[] house = new int[N];   // 집 좌표 배열

        // house 배열 입력
        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        // house 배열 오름차순 정렬
        Arrays.sort(house);

        int low = 1;    // 최소 거리가 가질 수 있는 최솟값
        int high = house[N - 1] - house[0]; // 최소 거리가 가질 수 있는 최댓값

        while (low <= high) {
            int mid = (low + high) / 2;

            // mid 거리에 대해 설치 가능한 공유기 개수가 C 개수에 못 미치면
            // 거리를 좁혀야 하므로 high를 줄인다.
            if (checkInstall(mid, house) < C) {
                high = mid - 1;
            }
            // 설치 가능한 공유기 개수가 C보다 크거나 같으면
            // 거리를 벌리면서 최소 거리가 가질 수 있는 최대 거리를 찾아낸다.
            else {
                low = mid + 1;
            }
        }

        System.out.println(high);

        br.close();
    }

    // 두 공유기 사이의 최소 거리가 dist일 때,
    // house 좌표에서 설치할 수 있는 공유기의 개수를 반환한다.
    private static int checkInstall(int dist, int[] house) {
        // 첫 번째 집은 무조건 설치한다고 가정
        int count = 1;
        int prevPos = house[0];

        for (int i = 1; i < house.length; i++) {
            int pos = house[i];

            // 현재 탐색하는 집의 위치와 직전에 설치했던 집의 위치 간의 거리가
            // 최소 거리(dist)보다 크거가 같을 때 공유기 설치 개수를 늘려주고
            // 마지막 설치 위치를 갱신한다.
            if (pos - prevPos >= dist) {
                count++;
                prevPos = pos;
            }
        }

        return count;
    }
}