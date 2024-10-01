package Programmers;

class Pro_순위 {
    public int solution(int n, int[][] results) {
        int[][] graph = new int[n + 1][n + 1];
        int answer = 0;

        for (int i = 0; i < results.length; i++) {
            int A = results[i][0];
            int B = results[i][1];
            graph[A][B] = 1;    // A는 B를 이겼다는 의미로 1을 저장
            graph[B][A] = -1;   // B는 A에게 졌다는 의미로 -1을 저장
        }

        // A 선수가 B 선수보다 실력이 좋다면 A 선수는 B 선수를 항상 이긴다는 조건은
        // "A가 B를 이기고, B가 C를 이겼다면, A는 항상 C를 이긴다"는 것을 알려준다.
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                for (int k = 1; k < n + 1; k++) {
                    // i 선수가 j 선수를 이기고, j 선수가 k 선수가 이겼다면
                    // i는 항상 k 선수를 이긴다.
                    if (graph[i][j] == 1 && graph[j][k] == 1) {
                        graph[i][k] = 1;
                        graph[k][i] = -1;
                    }

                    // i 선수가 j 선수에게 지고, j 선수가 k 선수에게 졌다면
                    // i는 항상 k 선수에게 진다.
                    if (graph[i][j] == -1 && graph[j][k] == -1) {
                        graph[i][k] = -1;
                        graph[k][i] = 1;
                    }
                }
            }
        }

        // 정보가 부족하지 않다면 graph는 자기 자신과의 대결을 제외한 모든 칸에 1 또는 -1이 들어있어야 한다.
        // 즉, 경기 결과가 n-1개를 가진 선수는 순위를 알 수 있다.
        for (int i = 1; i < n + 1; i++) {
            int count = 0;  // 경기 결과 수

            for (int j = 1; j < n + 1; j++) {
                if (graph[i][j] != 0) count++;
            }

            if (count == n - 1) answer++;
        }

        return answer;
    }
}
