package Programmers;

import java.util.Stack;

public class Pro_크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();  // 바구니
        int[] memo = new int[board.length]; // 마지막 탐색 위치 저장 배열
        int answer = 0; // 터진 인형의 개수

        // 크레인 작동
        for (int num : moves) {
            int col = num - 1;
            int row = memo[col];

            // 인형을 만날 때까지 열을 하나씩 내려간다.
            while (row < board.length) {
                int doll = board[row++][col];   // 인형의 모양

                // 인형 발견
                if (doll > 0) {
                    // 바구니의 가장 위의 인형의 모양과 같으면 인형 터트리기
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2;
                    }
                    // 아니라면 바구니에 인형 넣기
                    else {
                        basket.push(doll);
                    }

                    break;  // 탐색 종료
                }
            }

            // 마지막 탐색 위치 기억하기
            memo[col] = row;
        }

        return answer;
    }
}
