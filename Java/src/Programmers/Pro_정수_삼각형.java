package Programmers;

class Pro_정수_삼각형 {
    public int solution(int[][] triangle) {
        int height = triangle.length;   // 삼각형 높이
        int[][] dp = new int[height][height];   // 누적합을 저장할 배열
        int answer = 0;

        // 꼭대기(0층) 숫자를 dp에 저장한다.
        dp[0][0] = triangle[0][0];

        // 1층부터 바닥까지 내려오면서 갈 수 있는 모든 길의 최대 누적합을 dp에 저장한다.
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < i + 1; j++) {
                // 현재 요소가 왼쪽 끝에 있는 경우, 현재 값 + 위층 누적값(i-1, j)
                if (j == 0) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j];
                }
                // 현재 요소가 오른쪽 끝에 있는 경우, 현재 값 + 위층 누적값(i-1, j-1)
                else if (i == j) {
                    dp[i][j] = triangle[i][j] + dp[i - 1][j - 1];
                }
                // 현재 요소가 중간에 위치한 경우, 현재 값 + 위층의 왼쪽과 오른쪽 요소 중 최대값
                else
                    dp[i][j] = triangle[i][j] + Math.max(dp[i - 1][j - 1], dp[i - 1][j]);
            }
        }

        // 가장 마지막 층의 모든 요소 중 최댓값이 정답
        for (int i = 0; i < height; i++) {
            answer = Math.max(answer, dp[height - 1][i]);
        }

        return answer;
    }
}
