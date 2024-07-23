package Programmers;

class Pro_이모티콘_할인행사 {
    private static int[] emoticonsCopy;
    private static int[][] usersCopy;
    private static int[] rates = {0, 10, 20, 30, 40};
    private static int[] answer;

    public static int[] solution(int[][] users, int[] emoticons) {
        emoticonsCopy = emoticons;
        usersCopy = users;
        answer = new int[2];

        // 1. 최소, 최대 할인 기준 찾기
        int min = 40;
        int max = 0;

        for (int i = 0; i < users.length; i++) {
            min = Math.min(users[i][0], min);
            max = Math.max(users[i][0], max);
        }

        // 10의 배수가 아닌 경우
        if (min % 10 != 0) min = (min / 10 + 1) * 10;
        if (max % 10 != 0) max = (max / 10 + 1) * 10;

        // 2. 중복을 허용하는 할인율 조합 만들기
        combination(new int[emoticons.length], 0, min / 10, max / 10, emoticons.length);

        return answer;
    }


    private static void combination(int[] sel, int idx, int start, int n, int r) {
        if (r == 0) {
            // 3. 각 사용자의 이모티콘 구매 비용 계산
            int subscriberNum = 0;  // 서비스 가입 수
            int total = 0;  // 총 매출액

            for (int[] info : usersCopy) {
                int sum = 0;

                for (int i = 0; i < sel.length; i++) {
                    // 할인율이 사용자의 기존 비율 이상인 이모티콘 전부 구매
                    if (sel[i] >= info[0]) {
                        sum += emoticonsCopy[i] * (100 - sel[i]) / 100.0;
                    }
                }

                // 구매 비용이 사용자의 기준 가격 이상이면 서비스 가입
                if (sum >= info[1]) subscriberNum++;
                else total += sum;
            }

            // 4. 최대 목표치이면 갱신
            // 서비스 가입 수가 더 클 경우
            if (answer[0] < subscriberNum) {
                answer[0] = subscriberNum;
                answer[1] = total;
            }
            // 서비스 가입 수는 같지만 매출액이 더 클 경우
            else if (answer[0] == subscriberNum && answer[1] < total) {
                answer[1] = total;
            }

            return;
        }

        for (int i = start; i <= n; i++) {
            sel[idx] = rates[i];
            combination(sel, idx + 1, start, n, r - 1);
            sel[idx] = 0;
        }
    }
}
