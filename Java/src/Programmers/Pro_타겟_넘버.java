package Programmers;

class Pro_타겟_넘버 {
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        calc(0, 0, numbers, target);
        return answer;
    }

    public void calc(int depth, int sum, int[] numbers, int target) {
        if (depth == numbers.length) {
            if (sum == target) answer++;
            return;
        }

        // 더하기
        calc(depth + 1, sum + numbers[depth], numbers, target);

        // 빼기
        calc(depth + 1, sum - numbers[depth], numbers, target);
    }
}
