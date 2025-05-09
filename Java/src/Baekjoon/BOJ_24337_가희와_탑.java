package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_24337_가희와_탑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());       // 건물의 개수
        int a = Integer.parseInt(st.nextToken());       // 가희(왼쪽)가 볼 수 있는 건물의 개수
        int b = Integer.parseInt(st.nextToken());       // 단비(오른쪽)가 볼 수 있는 건물의 개수
        ArrayList<Integer> tower = new ArrayList<>();   // 탑 높이 리스트

        // 조건이 성립하지 않는 경우 -1을 출력한다.
        // 가장 높은 건물은 두 명 다 볼 수 있으므로 (A + B - 1 ≤ N)
        if (a + b - 1 > N) {
            System.out.println(-1);
            br.close();
            return;
        }

        // 왼쪽에서 가운데로 건물을 채운다.
        for (int i = 1; i < a; i++) {
            tower.add(i);
        }
        tower.add(Math.max(a, b));  // 가장 높은 건물은 a와 b 중 최대값

        // 가운데에서 오른쪽으로 건물을 채운다.
        for (int i = b - 1; i >= 1; i--) {
            tower.add(i);
        }

        // 나머지 건물을 1로 채운다.
        // a가 1인 경우 왼쪽 첫번째 건물이 가장 높아야하므로 1번 인덱스에서 시작한다.
        if (a == 1) {
            while (tower.size() < N) {
                tower.add(1, 1);
            }
        }
        // 아니라면 왼쪽부터 1로 채운다.
        else {
            while (tower.size() < N) {
                tower.add(0, 1);
            }
        }

        // 출력
        StringBuilder sb = new StringBuilder();
        for (int i : tower) {
            sb.append(i).append(" ");
        }

        System.out.println(sb);

        br.close();
    }
}
