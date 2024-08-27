package Programmers;

import java.util.*;

class Pro_가장_큰_수 {
    public static String solution(int[] numbers) {
        String[] arr = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        // int[]는 Comparator를 사용할 수 없다!
        Arrays.sort(arr, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        // 0으로 시작하는 경우 0으로 반환
        if (arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();

        for (String str : arr) {
            sb.append(str);
        }

        return sb.toString();
    }
}
