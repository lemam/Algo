package Programmers;

public class Pro_양궁대회 {
    private int maxDiff;
    private int[] answer;

    public int[] solution(int n, int[] info) {
        answer = new int[]{-1};

        dfs(info, new int[11], 0, n);

        return answer;
    }

    // depth 탐색한 과녁 (깊이)
    // count 쏜 화살의 개수
    private void dfs(int[] apeach, int[] ryan, int depth, int count) {
        // 모든 과녁을 다 탐색했다면
        if (depth == 11) {
            // 모든 화살을 썼다면 점수를 계산한다.
            if (count == 0) {
                int aScore = 0, rScore = 0; // 어피치, 라이언의 점수

                // 라이언이 맞춘 화살의 개수가 어피치보다 크면 점수를 얻는다.
                // 둘 다 못 맞춘 경우에는 얻는 점수 없음
                for (int i = 0; i < apeach.length; i++) {
                    if (apeach[i] == 0 && ryan[i] == 0) continue;
                    if (apeach[i] >= ryan[i]) aScore += 10 - i;
                    else rScore += 10 - i;
                }

                // 라이언이 이긴 경우
                if (rScore > aScore) {
                    // 점수 차이 비교해서 최댓값인 경우 갱신
                    int diff = rScore - aScore;

                    if (diff > maxDiff) {
                        maxDiff = diff;
                        answer = ryan.clone();
                    }
                    // 같은 점수 차이면 가장 낮은 점수를 더 맞힌 경우로 갱신
                    else if (diff == maxDiff) {
                        for (int i = ryan.length - 1; i >= 0; i--) {
                            if (answer[i] < ryan[i]) {
                                answer = ryan.clone();
                                return;
                            }

                            if (answer[i] > ryan[i]) return;
                        }
                    }
                }
            }

            return;
        }

        // 1. 둘 다 점수를 얻지 않는다. (0점)
        if (apeach[depth] == 0) {
            dfs(apeach, ryan, depth + 1, count);
        }

        // 2. 어피치를 이기고 점수를 얻는다.
        if (count >= apeach[depth] + 1) {
            ryan[depth] = apeach[depth] + 1;
            dfs(apeach, ryan, depth + 1, count - (apeach[depth] + 1));
            ryan[depth] = 0;
        }

        // 3. 어피치에게 지고 점수를 준다.
        if (apeach[depth] != 0) {
            for (int i = 0; i < apeach[depth]; i++) {
                ryan[depth] = i;
                dfs(apeach, ryan, depth + 1, count - i);
                ryan[depth] = 0;
            }
        }
    }
}
