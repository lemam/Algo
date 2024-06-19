package Programmers;

public class Pro_1차_프렌즈4블록 {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];  // 판의 블록 배열
        int answer = 0;

        // 블록 배열 초기화
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while (true) {
            boolean[][] isSameArr = new boolean[m][n];

            // 같은 모양의 2x2 블럭을 찾는다.
            checkSameBlock(m, n, map, isSameArr);

            // 블록을 삭제하고 그 개수를 저장한다.
            int count = removeBlock(m, n, map, isSameArr);

            // 삭제할 블록이 없는 경우 게임 종료
            if (count == 0) break;
            else answer += count;

            // 블록을 떨어뜨린다.
            dropBlock(m, n, map);
        }

        return answer;
    }

    private void dropBlock(int m, int n, char[][] map) {
        // 밑에서부터 위로 탐색
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                // 블록인 경우 건너뛰기
                if (map[i][j] != '*') continue;

                // 빈칸인 경우 빈칸 위에 있는 블록부터 0번까지 탐색하며 블록을 찾는다.
                for (int k = i - 1; k >= 0; k--) {
                    // 블록을 찾으면 아래로 한 칸 내리고 탐색 종료
                    if (map[k][j] != '*') {
                        map[i][j] = map[k][j];
                        map[k][j] = '*';
                        break;
                    }
                }
            }
        }
    }

    private int removeBlock(int m, int n, char[][] map, boolean[][] isSameArr) {
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 조건에 맞는 블록인 경우 삭제(*)하고 카운트한다.
                if (isSameArr[i][j] && map[i][j] != '*') {
                    count++;
                    map[i][j] = '*';
                }
            }
        }

        return count;
    }

    private void checkSameBlock(int m, int n, char[][] map, boolean[][] isSameArr) {
        // 모든 블록 탐색
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 탐색 범위가 판을 넘어가거나 빈칸인 경우 탐색 건너뛴다.
                if (i + 1 >= m || j + 1 >= n || map[i][j] == '*') continue;

                char curr = map[i][j];  // 현재 블록 모양

                // 2x2에 다 같은 모양이면 removeArr에 표시
                // 오른쪽, 아래, 오른쪽 아래 대각선 블록 순서
                if (curr == map[i][j + 1] && curr == map[i + 1][j] && curr == map[i + 1][j + 1]) {
                    isSameArr[i][j] = true;
                    isSameArr[i][j + 1] = true;
                    isSameArr[i + 1][j] = true;
                    isSameArr[i + 1][j + 1] = true;
                }
            }
        }
    }
}
