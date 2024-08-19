package Programmers;

class Pro_여행경로 {
    private String[] answer;

    public String[] solution(String[][] tickets) {
        String[] sel = new String[tickets.length + 1];  // 현재 선택한 경로

        // "ICN" 공항에서 출발
        sel[0] = "ICN";
        dfs(1, tickets, new boolean[tickets.length], sel);

        return answer;
    }

    private void dfs(int depth, String[][] tickets, boolean[] visited, String[] sel) {
        if (depth == sel.length) {
            if (answer == null) {
                answer = sel.clone();
                return;
            }

            // 경로가 복수일 경우, 알파벳 순서 비교하여 앞서는 경로 선택
            for (int i = 0; i < answer.length; i++) {
                if (!answer[i].equals(sel[i])) {
                    if (answer[i].compareTo(sel[i]) > 0) {
                        answer = sel.clone();
                    }
                    break;
                }
            }

            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            // 이전에 선택한 항공권의 도착 공항(sel[depth - 1]) == 다음 선택할 항공권의 출발 공항(tickets[i][0])
            // 선택한 적 없는 항공권이라면 선택
            if (sel[depth - 1].equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                sel[depth] = tickets[i][1];
                dfs(depth + 1, tickets, visited, sel);
                visited[i] = false;
            }
        }
    }
}
