package Programmers;

import java.util.HashMap;

public class Pro_성격_유형_검사하기 {
    public String solution(String[] survey, int[] choices) {
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};    // 성격 유형 종류 배열
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};                     // 각 선택지의 점수 배열
        HashMap<Character, Integer> resultMap = new HashMap<>();    // 유형별 성격 검사 점수 결과
        StringBuilder sb = new StringBuilder();

        // resultMap 초기화
        for (char type : types) {
            resultMap.put(type, 0);
        }

        // 검사 결과 집계
        for (int i = 0; i < survey.length; i++) {
            char leftType = survey[i].charAt(0);
            char rightType = survey[i].charAt(1);

            // 점수가 4 미만이면 왼쪽 타입에 점수를 추가
            if (choices[i] < 4) {
                resultMap.put(leftType, score[choices[i]] + resultMap.get(leftType));
            }
            // 점수가 4 초과이면 오른쪽 타입에 점수를 추가
            else if (choices[i] > 4) {
                resultMap.put(rightType, score[choices[i]] + resultMap.get(rightType));
            }
        }

        // 성격 유형 선택
        for (int i = 0; i < types.length; i += 2) {
            // 왼쪽과 오른쪽 성격 유형의 점수를 비교한다.
            int left = resultMap.get(types[i]);
            int right = resultMap.get(types[i + 1]);

            // 왼쪽의 점수가 더 크거나 두 유형의 점수가 같은 경우 왼쪽을 선택한다.
            // 점수가 같은 경우 사전 순으로 빠른 것 선택 -> 주어진 지표에서 왼쪽 성격이 항상 빠르므로 왼쪽 선택
            if (left >= right) {
                sb.append(types[i]);
            }
            // 오른쪽이 더 큰 경우 오른쪽을 선택한다.
            else {
                sb.append(types[i + 1]);
            }
        }

        return sb.toString();
    }
}
