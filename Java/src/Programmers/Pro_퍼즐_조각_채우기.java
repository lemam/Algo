package Programmers;

import java.util.*;

class Pro_퍼즐_조각_채우기 {
    public static int solution(int[][] game_board, int[][] table) {
        List<List<int[]>> boards = new ArrayList<>();   // game_board에 있는 빈 공간들의 좌표 리스트 List<List<[row, col]>>
        List<List<int[]>> puzzles = new ArrayList<>();  // table에 있는 퍼즐 조각들의 좌표 리스트
        int N = game_board.length;
        int answer = 0;

        // game_board의 빈 공간들의 좌표 구하기
        // 모든 칸을 탐색하면서 빈 칸인 곳을 찾는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (game_board[i][j] == 0) {
                    // BFS를 이용하여 현재 빈칸과 이어진 공간들의 좌표 리스트를 구해 boards에 저장한다.
                    boards.add(getPuzzleCoords(i, j, game_board, true));
                }
            }
        }

        // table의 퍼즐 좌표 구하기
        // 모든 칸을 탐색하면서 채워진 칸인 곳을 찾는다.
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (table[i][j] == 1) {
                    // BFS를 이용하여 현재 블록과 이어진 공간들의 좌표 리스트를 구해 puzzles에 저장한다.
                    puzzles.add(getPuzzleCoords(i, j, table, false));
                }
            }
        }

        // boards의 공간과 맞는 퍼즐이 있는지 확인한다.
        for (List<int[]> board : boards) {
            for (int i = 0; i < puzzles.size(); i++) {
                List<int[]> puzzle = puzzles.get(i);

                // 퍼즐 크기가 공간 격자 크기와 같지 않으면 건너뛴다.
                if (puzzle.size() != board.size()) continue;

                // 크기가 같다면 맞는 모양인지 확인한다.
                if (checkRightPuzzle(board, puzzle)) {
                    answer += puzzle.size();    // 채운 칸 개수 추가
                    puzzles.remove(i);  // 사용한 퍼즐 삭제
                    break;
                }
            }
        }

        return answer;
    }

    // 두 리스트 board와 puzzle이 서로 같은 값을 가지고 있는지를 반환한다.
    // puzzle을 회전해서도 확인한다.
    private static boolean checkRightPuzzle(List<int[]> board, List<int[]> puzzle) {
        // puzzle 리스트 복사본 생성
        List<int[]> puzzleCopy = new ArrayList<>();
        puzzleCopy.addAll(puzzle);

        // board와 puzzleCopy의 값이 같은지 확인한다.
        // 총 3번 회전할 수 있다.
        for (int r = 0; r < 4; r++) {
            boolean flag = true;    // 다름 여부 체크

            for (int i = 0; i < board.size(); i++) {
                // board와 puzzleCopy의 좌표가 서로 같지 않은 경우
                if (!Arrays.equals(board.get(i), puzzleCopy.get(i))) {
                    // 퍼즐을 회전시켜 다시 확인한다. (r=3은 처음으로 돌아가는 것이므로 필요 없음)
                    if (r < 3) rotatePuzzle(puzzleCopy);
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
        }

        return false;
    }

    // 퍼즐을 시계방향 90도로 회전한다.
    private static void rotatePuzzle(List<int[]> puzzleCopy) {
        int size = puzzleCopy.size();

        // 1. 모든 요소의 row 값에 -1을 곱한 후, row와 col의 값을 서로 바꾼다.
        for (int i = 0; i < size; i++) {
            int[] coord = puzzleCopy.get(i);
            puzzleCopy.set(i, new int[]{coord[1], coord[0] * -1});
        }

        // 2. 루트 좌표를 맨 앞으로 이동시킨다.
        // 상단 그리고 좌측으로 우선 정렬
        sortPuzzleList(puzzleCopy);

        // 루트 좌표가 {0, 0}이 되도록 모든 좌표를 재계산한다.
        if (!Arrays.equals(puzzleCopy.get(0), new int[]{0, 0})) {
            int rr = 0, rc = 0;

            for (int i = 0; i < puzzleCopy.size(); i++) {
                int[] coord = puzzleCopy.get(i);

                if (i == 0) {
                    rr = coord[0];
                    rc = coord[1];
                }

                puzzleCopy.set(i, new int[]{coord[0] - rr, coord[1] - rc});
            }
        }
    }

    // 리스트의 좌표를 상단 그리고 왼쪽을 우선으로 정렬한다.
    private static void sortPuzzleList(List<int[]> list) {
        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
    }

    /**
     * BFS를 이용하여 모양의 모든 좌표들을 구한다.
     *
     * @param row         시작 행
     * @param col         시작 열
     * @param map         탐색에 사용되는 배열
     * @param isGameBoard map이 game_boards인지 확인하는 변수
     * @return 상단 그리고 왼쪽을 우선으로 하는 정렬된 좌표 배열을 담은 리스트
     */
    private static List<int[]> getPuzzleCoords(int row, int col, int[][] map, boolean isGameBoard) {
        int[] dr = {-1, 0, 1, 0};   // 12 3 6 9
        int[] dc = {0, 1, 0, -1};

        int N = map.length;
        int target = isGameBoard ? 0 : 1;   // game_board 라면 빈 공간(0)을, 아니라면 블록(1)을 타깃으로 한다.
        ArrayList<int[]> result = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();

        queue.add(new int[]{row, col});
        result.add(new int[]{0, 0});    // 시작하는(루트) 좌표는 {0, 0}
        map[row][col] = (target + 1) % 2;   // 탐색을 완료한 곳은 블록 또는 빈칸로 채운다.

        // BFS
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            // 4방 탐색
            for (int dir = 0; dir < 4; dir++) {
                int nr = curr[0] + dr[dir];
                int nc = curr[1] + dc[dir];

                // 다음 위치가 map 범위 밖이거나 target이 아니면 건너뛴다.
                if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != target) continue;

                // target이라면 좌표를 저장하고, 그 위치를 블록 또는 빈칸으로 채운다.
                queue.add(new int[]{nr, nc});
                result.add(new int[]{nr - row, nc - col});  // 루트 좌표를 기준으로 한 상대 좌표 저장
                map[nr][nc] = (target + 1) % 2;
            }
        }

        // 더 위에 있고, 더 왼쪽에 있는 좌표를 우선으로 정렬한다.
        sortPuzzleList(result);

        return result;
    }
}
