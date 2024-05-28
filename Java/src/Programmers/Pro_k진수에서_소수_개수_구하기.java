package Programmers;

public class Pro_k진수에서_소수_개수_구하기 {
    public static int solution(int n, int k) {
        // 1. K 진수로 바꾸기
        String kNumber = Integer.toString(n, k);

        // 2. 조건에 맞는 숫자 찾기
        // 0을 기준으로 문자열 나누기
        String[] numbers = kNumber.split("0");

        // 3. 소수인지 확인
        int answer = 0;

        for (String numStr : numbers) {
            if (numStr.isEmpty() || numStr.isBlank()) continue;
            if (isPrime(Long.parseLong(numStr))) {
                answer++;
            }
        }

        return answer;
    }

    private static boolean isPrime(Long num) {
        if (num == 1) return false;
        if (num == 2) return true;

        int count = 0;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
