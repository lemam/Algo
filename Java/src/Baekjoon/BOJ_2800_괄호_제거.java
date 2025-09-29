package Baekjoon;

import java.io.*;
import java.util.*;

public class BOJ_2800_괄호_제거 {
    private static char[] inputs;
    private static Set<String> result;
    private static List<int[]> brackets;
    private static boolean[] sel;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        inputs = br.readLine().toCharArray();   // 입력받은 수식을 char[]로 변환
        result = new TreeSet<>();   // 결과를 저장할 HashSet

        // 1. 괄호 쌍 인덱스 구하기
        Stack<Integer> stack = new Stack<>();
        brackets = new ArrayList<>();   // 괄호 쌍의 인덱스 쌍을 저장할 리스트

        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == '(') stack.push(i);
            else if (inputs[i] == ')') brackets.add(new int[]{stack.pop(), i});
        }

        // 2. 모든 조합 구하기
        sel = new boolean[inputs.length];   // 문자를 제거할지 판단하는 배열
        comb(0);

        // 3. 출력
        StringBuilder sb = new StringBuilder();

        for (String str : result) {
            sb.append(str).append("\n");
        }

        System.out.println(sb);
    }

    private static void comb(int depth) {
        // 모든 괄호 탐색 완료
        if (depth == brackets.size()) {
            boolean flag = false;   // 괄호가 1개 이상 제거되었는지 여부
            StringBuilder sb = new StringBuilder();

            // 제거할 괄호를 제외한 나머지 문자들을 sb에 넣는다.
            for (int i = 0; i < inputs.length; i++) {
                if (!sel[i]) sb.append(inputs[i]);
                else flag = true;
            }

            // 최소 1개의 괄호가 제거되었다면 해당 수식을 result에 저장
            if (flag) result.add(sb.toString());

            return;
        }

        // 괄호 제거 안 하기
        comb(depth + 1);

        // 괄호 제거하기
        int[] curr = brackets.get(depth);
        sel[curr[0]] = true;
        sel[curr[1]] = true;
        comb(depth + 1);
        sel[curr[0]] = false;   // 원상복구
        sel[curr[1]] = false;
    }
}
