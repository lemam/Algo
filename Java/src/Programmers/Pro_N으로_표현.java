package Programmers;

import java.util.*;

class Pro_N으로_표현 {
    public int solution(int N, int number) {
        List<Set<Integer>> setList = new ArrayList<>();

        // HashSet은 N을 k번 사용해서 만들 수 있는 숫자들의 집합이다.
        // 최솟값이 8보다 커지는 경우는 계산하지 않아도 되므로 1 ~ 8까지의 HashSet을 만든다.
        for (int i = 0; i < 9; i++) {
            setList.add(new HashSet<>());
        }

        setList.get(1).add(N);  // N 1개로 만들 수 있는 수는 나 자신 뿐이다.

        // 만들어야할 값이 N과 같으면 1을 반환한다.
        if (number == N) return 1;

        // 2부터 8까지의 set을 만든다.
        for (int i = 2; i < 9; i++) {
            // 두 집합을 합쳐 i번째 집합을 만든다.
            // set2 = (1, 1), (1, 1)
            // set3 = (2, 1), (1, 2)
            // set4 = (3, 1), (1, 3), (2, 2), (2, 2)
            // ...
            for (int j = 1; j <= i / 2; j++) {
                // 괄호연산이 가능하므로 반대 연산도 진행한다.
                unionSet(setList.get(i), setList.get(i - j), setList.get(j));
                unionSet(setList.get(i), setList.get(j), setList.get(i - j));
            }

            // N이 i번 연속하는 숫자도 요소로 넣는다.
            String n = Integer.toString(N);
            setList.get(i).add(Integer.parseInt(n.repeat(i)));

            // i번째 집합에 number가 있으면 i를 반환한다.
            for (int num : setList.get(i)) {
                if (num == number) return i;
            }
        }

        // 최솟값이 8보다 크면 -1을 반환한다.
        return -1;
    }

    // 집합 a와 집합 b의 요소를 사칙연산하여 합친 값을 union에 담는다.
    private void unionSet(Set<Integer> union, Set<Integer> a, Set<Integer> b) {
        for (int n1 : a) {
            for (int n2 : b) {
                union.add(n1 + n2);
                union.add(n1 - n2);
                union.add(n1 * n2);
                if (n2 != 0) union.add(n1 / n2);
            }
        }
    }
}
