package Programmers;

import java.util.ArrayList;
import java.util.Collections;

public class Pro_뉴스_클러스터링 {
    public static void main(String[] args) {
        System.out.println(solution("FRANCE", "french"));
    }

    public static int solution(String str1, String str2) {
        // 1. 다 소문자로 만들기
        // 2. 다중집합으로 만들기
        ArrayList<String> A = initStringSet(str1.toLowerCase());
        ArrayList<String> B = initStringSet(str2.toLowerCase());

        // 3. 중복원소 처리를 위한 정렬
        Collections.sort(A);
        Collections.sort(B);

        // 4. 교집합, 합집합 구하기
        ArrayList<String> intersection = new ArrayList<>();
        ArrayList<String> union = new ArrayList<>();

        // A의 원소가 B에 포함되는지 확인
        // 포함된다면 교집합에 넣고 B에서 삭제
        // 합집합은 포함됨과 상관없이 넣기
        for (String s : A) {
            if (B.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        // B에 남아있는 원소를 합집합에 넣기
        union.addAll(B);

        // 5. 자카드 유사도 구하기
        double jakard = 0;

        // 둘 다 공집합인 경우 1 반환
        if (union.isEmpty()) {
            jakard = 1;
        }
        // 교집합의 크기 / 합집합의 크기
        else {
            jakard = (double) intersection.size() / (double) union.size();
        }

        // 65536을 곱한 후에 소수점 아래를 버리고 정수부만 출력
        return (int) (jakard * 65536);
    }

    private static ArrayList<String> initStringSet(String str) {
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < str.length() - 1; i++) {
            char x = str.charAt(i);
            char y = str.charAt(i + 1);

            if (Character.isAlphabetic(x) && Character.isAlphabetic(y)) {
                list.add("" + x + y);
            }
        }

        return list;
    }
}
