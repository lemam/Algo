package Programmers;

class Pro_도둑질 {
    public int solution(int[] money) {
        int[] dpFirst = new int[money.length];  // 첫집을 털었을 경우 -> 마지막 집을 털 수 없다.
        int[] dpSecond = new int[money.length]; // 첫집을 털지 않는 경우 -> 마지막 집을 털 수 있다.

        // dp 배열 초기화
        for (int i = 0; i < money.length; i++) {
            dpFirst[i] = money[i];
            dpSecond[i] = money[i];
        }

        dpFirst[1] = -1;            // 첫집을 털면 옆집은 털 수 없음
        dpSecond[0] = -1;           // 첫집을 털지 않음
        dpFirst[2] += dpFirst[0];   // 세번째 집은 무조건 첫집을 털 수 밖에 없다.

        // 점화식 : dp[i] = money[i] + Math.max(dp[i-2], dp[i-3]);
        // 현재 집을 털고, 앞앞집을 터는 경우 → money[i] + dp[i-2]
        // 현재 집을 털고, 앞앞앞집을 터는 경우 → money[i] + dp[i-3]
        for (int i = 3; i < money.length; i++) {
            dpFirst[i] += Math.max(dpFirst[i - 2], dpFirst[i - 3]);
            dpSecond[i] += Math.max(dpSecond[i - 2], dpSecond[i - 3]);
        }

        // dpFirst는 뒤에서 2번째나 3번째 값이 최댓값이 된다.
        // dpSecond는 뒤에서 1번째나 2번째 값이 최댓값이 된다.
        int firstMax = Math.max(dpFirst[money.length - 3], dpFirst[money.length - 2]);
        int secondMax = Math.max(dpSecond[money.length - 2], dpSecond[money.length - 1]);

        // 그 중 최댓값을 반환한다.
        return Math.max(firstMax, secondMax);
    }
}
