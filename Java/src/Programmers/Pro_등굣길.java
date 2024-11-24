package Programmers;

class Pro_등굣길 {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] map = new int[n + 1][m + 1];

        // 물이 잠긴 지역의 좌표는 -1로 표시한다.
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;  // 처음 시작 좌표에 1을 넣는다.

        // (1, 1)부터 (n, m)까지 탐색하면서 경로의 수를 채운다.
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // 현재 좌표가 물이 잠긴 지역인 경우
                if (map[i][j] == -1) continue;
                // 현재 좌표의 위쪽 좌표의 값이 0보다 큰 경우
                if (map[i - 1][j] > 0) map[i][j] += map[i - 1][j] % mod;
                // 현재 좌표의 오른쪽 좌표의 값이 0보다 큰 경우
                if (map[i][j - 1] > 0) map[i][j] += map[i][j - 1] % mod;
            }
        }

        // 학교까지 갈 수 있는 최단경로의 개수를 1,000,000,007로 나눈 나머지를 반환한다.
        return map[n][m] % mod;
    }
}
