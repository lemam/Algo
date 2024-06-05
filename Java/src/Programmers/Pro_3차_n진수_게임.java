package Programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Pro_3차_n진수_게임 {
    // 진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
    public String solution(int n, int t, int m, int p) {
        int currNum = 0;    // 현재 불러야 할 10진수 번호
        int currTurn = 1;   // 현재 순서
        int myTurn = p;     // 튜브의 다음 순서
        int count = 0;      // 튜브가 말한 숫자 횟수
        StringBuilder answer = new StringBuilder();

        // currNum을 n진법으로 변환한 문자열을 가진 큐
        Queue<String> queue = new LinkedList<>();
        queue.add(currNum + "");

        // t개를 말할 때까지 반복
        while (count < t) {
            // 큐가 비어있는 경우 불러야할 다음 숫자를 확인한다.
            if (queue.isEmpty()) {
                currNum++;

                // 10진법인 경우 바로 큐에 저장
                if (n == 10) {
                    queue.add(currNum + "");
                }
                // n진법으로 변환한 후 분해해서 저장 (알파벳은 대문자로 변환)
                else {
                    String[] arr = Integer.toString(currNum, n).toUpperCase().split("");
                    queue.addAll(Arrays.asList(arr));
                }
            }

            // 큐에 들어있는 문자를 하나씩 뺀다.
            String num = queue.poll();

            // 내 차례인 경우
            if (currTurn == myTurn) {
                answer.append(num); // 정답 저장
                myTurn += m;    // 다음 턴 계산
                count++;
            }

            currTurn++;
        }

        return answer.toString();
    }
}
