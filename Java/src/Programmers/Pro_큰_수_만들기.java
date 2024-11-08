package Programmers;

public class Pro_큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder();
        int length = number.length();
        int maxIdx = 0;    // 탐색을 시작할 인덱스

        // (전체길이 - k)번 i를 하나씩 증가시키며 반복한다.
        for (int i = 0; i < length - k; i++) {
            char max = 0;   // 최댓값

            // i ~ (i + k)까지의 범위를 탐색하여 최댓값을 찾는다.
            // 단, 이전 탐색에서 선택한 수의 다음 인덱스부터 탐색을 시작한다.
            for (int j = maxIdx; j <= i + k; j++) {
                if (max < number.charAt(j)) {
                    max = number.charAt(j);
                    maxIdx = j + 1;
                }
            }

            result.append(max);
        }

        return result.toString();
    }
}
