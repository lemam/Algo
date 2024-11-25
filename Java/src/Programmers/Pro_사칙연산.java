package Programmers;

class Pro_사칙연산 {
    public int solution(String arr[]) {
        int size = arr.length / 2 + 1;
        char[] operations = new char[size - 1];
        int[] numbers = new int[size];

        int[][] max = new int[size][size];
        int[][] min = new int[size][size];

        // max, min 배열 초기화
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }

        // 숫자와 연산자를 나눠 저장한다.
        for (int i = 0; i < arr.length; i++) {
            // 홀수면 피연산자
            if (i % 2 == 0) {
                numbers[i / 2] = Integer.parseInt(arr[i]);
            }
            // 짝수면 연산자
            else {
                operations[i / 2] = arr[i].charAt(0);
            }
        }

        // diff: 괄호 사이의 숫자 개수
        // start: 괄호가 시작되는 숫자 인덱스
        // end: 괄호가 끝나는 숫자 인덱스
        // op: 두 괄호 사이의 연산자 인덱스
        for (int diff = 0; diff < numbers.length; diff++) {
            for (int start = 0; start < numbers.length - diff; start++) {
                int end = start + diff;

                if (start == end) {
                    max[start][end] = numbers[start];
                    min[start][end] = numbers[start];
                    continue;
                }

                for (int op = start; op < end; op++) {
                    calc(operations, max, min, start, end, op);
                }
            }
        }

        return max[0][numbers.length - 1];
    }

    private void calc(char[] operations, int[][] max, int[][] min, int start, int end, int op) {
        // [start][op]: start 숫자부터 op 연산자 전까지의 숫자들의 합
        // [op + 1][end]: op 연산자 이후 숫자부터 end 숫자까지의 숫자들의 합

        // 연산자가 '+'인 경우
        // 최대값 = 최대 + 최대
        // 최소값 = 최소 + 최소
        if (operations[op] == '+') {
            max[start][end] = Math.max(max[start][end], max[start][op] + max[op + 1][end]);
            min[start][end] = Math.min(min[start][end], min[start][op] + min[op + 1][end]);
        }
        // 연산자가 '-'인 경우
        // 최대값 = 최대 - 최소
        // 최소값 = 최소 - 최대
        else {
            max[start][end] = Math.max(max[start][end], max[start][op] - min[op + 1][end]);
            min[start][end] = Math.min(min[start][end], min[start][op] - max[op + 1][end]);
        }
    }
}
