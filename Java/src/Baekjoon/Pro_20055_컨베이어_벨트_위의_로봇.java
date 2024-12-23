package Baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Pro_20055_컨베이어_벨트_위의_로봇 {
    private static int N, K;
    private static LinkedList<Belt> conveyor;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());   // 벨트의 한 면의 길이
        K = Integer.parseInt(st.nextToken());   // 내구도가 0인 칸의 최대 개수
        conveyor = new LinkedList<>(); // 컨베이어 벨트 리스트
        int step = 0;   // 수행한 단계 횟수

        // 내구도 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N * 2; i++) {
            conveyor.add(new Belt(Integer.parseInt(st.nextToken())));
        }

        // 내구도가 0인 벨트가 K개 이하이면 단계 수행
        while (K > 0) {
            step++;
            moveConveyor();
            moveRobot();
        }

        System.out.println(step);

        br.close();
    }

    // 로봇 이동
    private static void moveRobot() {
        // 1번과 N번 칸은 무조건 로봇이 없으므로
        // N-1번 칸부터 2번 벨트까지 탐색
        for (int i = N - 2; i > 0; i--) {
            // 현재 벨트 위에 로봇이 없으면 건너뛴다.
            if (!conveyor.get(i).hasRobot) continue;

            // 다음 벨트에 로봇이 있거나 다음 벨트의 내구도가 0이면 이동할 수 없다.
            if (conveyor.get(i + 1).hasRobot || conveyor.get(i + 1).durabiity <= 0) continue;

            // 로봇을 다음 벨트로 이동하고 내구도를 깎는다.
            conveyor.get(i).hasRobot = false;
            conveyor.get(i + 1).putRobot();
            if (conveyor.get(i + 1).durabiity <= 0) K--;

            // 내리는 위치(N번)로 로봇이 이동했다면 로봇을 내린다.
            if (i + 1 == N - 1) conveyor.get(i + 1).hasRobot = false;
        }

        // 올리는 위치(1번)에 내구도가 1 이상이면 로봇을 올린다.
        if (conveyor.get(0).durabiity > 0) {
            conveyor.get(0).putRobot();
            if (conveyor.get(0).durabiity <= 0) K--;
        }
    }

    // 컨베이어 벨트 이동
    private static void moveConveyor() {
        conveyor.add(0, conveyor.removeLast()); // 벨트를 한 칸씩 이동

        // N번째 칸에 로봇이 있었다면 로봇을 내린다.
        if (conveyor.get(N - 1).hasRobot)
            conveyor.get(N - 1).hasRobot = false;
    }

    private static class Belt {
        int durabiity;  // 내구도
        boolean hasRobot;   // 로봇 존재 여부

        public Belt(int durabiity) {
            this.durabiity = durabiity;
            hasRobot = false;
        }

        // 로봇 올리기
        public void putRobot() {
            hasRobot = true;
            durabiity--;
        }
    }
}
