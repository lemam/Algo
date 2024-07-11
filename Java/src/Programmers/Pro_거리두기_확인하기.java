package Programmers;

public class Pro_거리두기_확인하기 {
    public int[] solution(String[][] places) {
        // 탐색 델타 배열 (행, 열)
        int[] dr = {0, 0, 1, 1, 2, -1};
        int[] dc = {1, 2, 0, 1, 0, 1};

        int N = 5;  // 대기실의 개수
        int[] answer = new int[N];

        // 모든 대기실 탐색
        for (int p = 0; p < N; p++) {
            char[][] map = new char[N][N];  // 대기실의 구조 배열

            // map 초기화
            for (int i = 0; i < N; i++) {
                map[i] = places[p][i].toCharArray();
            }

            int result = 1; // 모든 응시자가 거리두기를 지키고 있으면 1, 아니라면 0

            // 대기실 모든 칸 탐색
            loop:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 응시자가 아니면 스킵한다.
                    if (map[i][j] != 'P') continue;

                    // 응시자인면 맨해튼 거리 2 이하에 다른 응시자가 있는지 찾는다.
                    for (int dir = 0; dir < dr.length; dir++) {
                        int nr = i + dr[dir];
                        int nc = j + dc[dir];

                        // 다음 탐색 위치가 map 범위를 벗어나면 스킵한다.
                        if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                        // 다음 탐색 위치가 응시자인 경우
                        if (map[nr][nc] == 'P') {
                            // (0, 2) 방향이면 (0, 1)에 파티션이 있는지 확인하고 있으면 스킵한다.
                            if (dir == 1) {
                                if (map[nr][nc - 1] != 'X') {
                                    result = 0;
                                    break loop;
                                }
                            }
                            // (1, 1) 방향이면 (0, 1)과 (1, 0)에 파티션이 있는지 확인하고 있으면 스킵한다.
                            else if (dir == 3) {
                                if (map[nr - 1][nc] != 'X' || map[nr][nc - 1] != 'X') {
                                    result = 0;
                                    break loop;
                                }
                            }
                            // (2, 0) 방향이면 (1, 0)에 파티션이 있는지 확인하고 있으면 스킵한다.
                            else if (dir == 4) {
                                if (map[nr - 1][nc] != 'X') {
                                    result = 0;
                                    break loop;
                                }
                            }
                            // (-1, 1) 방향이면 (0, 1)과 (-1, 0)에 파티션이 있는지 확인하고 있으면 스킵한다.
                            else if (dir == 5) {
                                if (map[nr + 1][nc] != 'X' || map[nr][nc - 1] != 'X') {
                                    result = 0;
                                    break loop;
                                }
                            }
                            // 아니라면 거리두기를 하지 않은 것으로 판단한다.
                            else {
                                result = 0;
                                break loop;
                            }
                        }
                    }
                }
            }

            // 결과값을 answer에 넣는다.
            answer[p] = result;
        }

        return answer;
    }
}
