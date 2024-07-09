package Programmers;

import java.util.ArrayList;
import java.util.List;

public class Pro_수식_최대화 {
    private static final String[] OPERATORS = {"*", "+", "-"};
    private static List<Long> numList;
    private static List<String> opList;
    private static boolean[] visited;
    private static long answer;

    public static long solution(String expression) {
        numList = new ArrayList<>();
        opList = new ArrayList<>();
        visited = new boolean[OPERATORS.length];
        answer = 0;

        // 숫자와 연산자로 나눠서 리스트에 저장
        String num = "";
        int expSize = expression.length();

        for (int i = 0; i < expSize; i++) {
            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {
                opList.add(ch + "");
                numList.add(Long.parseLong(num));
                num = "";
            } else {
                num += ch;
            }
        }

        numList.add(Long.parseLong(num));    // 마지막 숫자 저장

        // 연산자 우선순위 조합 생성
        permutation(0, new String[3]);

        return answer;
    }


    private static void permutation(int depth, String[] result) {
        // 우선순위에 맞춰 수식 계산
        // 그 결과값의 절댓값과 비교하여 더 큰 수를 answer에 저장
        if (depth == OPERATORS.length) {
            answer = Math.max(answer, Math.abs(calculateFormula(result)));
            return;
        }

        for (int i = 0; i < OPERATORS.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            result[depth] = OPERATORS[i];
            permutation(depth + 1, result);
            visited[i] = false;
        }
    }

    private static long calculateFormula(String[] priorityOperators) {
        // numList, opList 복사본 생성
        List<Long> numListCopy = new ArrayList<>(numList);
        List<String> opListCopy = new ArrayList<>(opList);

        // 우선순위 순서대로 연산
        for (String op : priorityOperators) {
            for (int i = 0; i < opListCopy.size(); i++) {
                if (opListCopy.get(i).equals(op)) {
                    // 해당 연산자에 의해 처리되는 두 피연산자를 가져온다.
                    long num1 = numListCopy.get(i);
                    long num2 = numListCopy.get(i + 1);

                    // 사용한 연산자와 숫자들은 삭제하고 계산한 숫자를 그 위치에 다시 넣는다.
                    // 순서가 꼬이지 않도록 뒤에서부터 삭제
                    numListCopy.remove(i + 1);
                    numListCopy.set(i, calc(num1, num2, op));
                    opListCopy.remove(i);
                    i--; // 현재 인덱스 다시 탐색
                }
            }
        }

        return numListCopy.get(0);
    }

    private static long calc(long num1, long num2, String op) {
        long result = 0;

        switch (op) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
        }

        return result;
    }
}
