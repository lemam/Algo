package Programmers;

class Pro_피로도 {
    private int answer;

    public int solution(int k, int[][] dungeons) {
        dfs(0, 0, new boolean[dungeons.length], dungeons);
        return answer;
    }

    /**
     * 유저가 탐험할수 있는 최대 던전 수를 answer에 저장한다.
     *
     * @param count    탐험한 던전 수
     * @param k        현재 피로도
     * @param visited  방문 체크용 배열
     * @param dungeons 던전 배열
     */
    private void dfs(int count, int k, boolean[] visited, int[][] dungeons) {
        // 순서 고려해서 조합 구하기
        for (int i = 0; i < dungeons.length; i++) {
            // 방문하지 않은 던전이고, 현재 피로도가 던전의 '최소 피로도' 이상이면
            // 피로도를 '소모 피로도'만큼 빼고 카운트를 하나 증가시켜 재귀한다.
            if (!visited[i] && dungeons[i][0] <= k) {
                visited[i] = true;
                dfs(count + 1, k - dungeons[i][1], visited, dungeons);
                visited[i] = false;
            }
        }

        // 최대값을 갱신하고 백트래킹한다.
        answer = Math.max(answer, count);
    }
}
