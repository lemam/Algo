package Programmers;

public class Pro_문자열_압축 {
    public int solution(String s) {
        int size = s.length();
        int answer = 1000;

        // 1부터 s의 길이까지 단위로 정하여 순회
        for (int unit = 1; unit <= size; unit++) {
            StringBuilder sb = new StringBuilder();
            String prev = "";   // 이전 단위 문자열
            int count = 1;  // prev 개수

            // 단위 문자열끼리 비교 후 압축
            for (int i = 0; i < size; i += unit) {
                String curr = s.substring(i, Math.min(i + unit, size)); // 현재 단위 문자열

                // 이전 단위 문자열이 현재 것과 같은지 비교
                if (prev.equals(curr)) {
                    count++;    // 같은 단위 문자열 개수 카운트
                } else {
                    // 압축한 문자열 저장
                    String number = count == 1 ? "" : "" + count;
                    sb.append(number).append(prev);

                    // 초기화
                    prev = curr;
                    count = 1;
                }
            }

            // 남은 문자열 붙이기
            String number = count == 1 ? "" : "" + count;
            sb.append(number).append(prev);

            // 최소 길이 갱신
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
