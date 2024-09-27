package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_5073_삼각형과_세_변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new BufferedReader(new InputStreamReader(System.in)));
        StringTokenizer st = null;

        while (true) {
            st = new StringTokenizer(br.readLine());

            // 삼각형의 세 변 입력받아 내림차순으로 정렬
            int[] edges = new int[3];
            for (int i = 0; i < 3; i++) {
                edges[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(edges);

            // 마지막 줄이면 종료한다.
            if (edges[0] == 0) break;

            // 1. 삼각형의 조건 맞는지 확인하기
            // 아니라면 Invalid 출력
            if (!isTriangle(edges)) {
                System.out.println("Invalid");
                continue;
            }

            // 2. 변의 길이 비교하기
            int count = getEqualEdgeCount(edges);

            if (count == 3) System.out.println("Equilateral");
            else if (count == 1) System.out.println("Isosceles");
            else if (count == 0) System.out.println("Scalene");
        }

        br.close();
    }

    // 삼각형의 세 변의 길이 중 서로 같은 변의 개수를 반환한다.
    private static int getEqualEdgeCount(int[] edges) {
        int count = 0;

        if (edges[0] - edges[1] == 0) count++;
        if (edges[1] - edges[2] == 0) count++;
        if (edges[2] - edges[0] == 0) count++;

        return count;
    }

    // 나머지 두 변의 길이의 합이 가장 긴 변보다 크면 삼각형의 조건을 만족한다.
    private static boolean isTriangle(int[] edges) {
        return edges[0] + edges[1] > edges[2];
    }
}

