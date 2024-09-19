package Programmers;

class Pro_카펫 {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // 총 격자의 수
        int[] answer = new int[2];

        // 한 변의 길이가 최소 3 이상이어야만 가운데에 노란 격자를 넣을 수 있다.
        for (int i = 3; i < total; i++) {
            int j = total / i;  // i와 j는 total의 약수여야 한다.

            // i가 total의 약수이고, j가 3 이상이면
            if (total % i == 0 && j >= 3) {
                // 가로 길이가 세로 길이 이상이므로 더 큰 값을 가로로 한다.
                int width = Math.max(i, j);
                int height = Math.min(i, j);
                int center = (width - 2) * (height - 2);    // 테두리 제외 가운데 격자 넓이

                // 가운데 넓이가 yellow와 같으면 정답이다.
                if (center == yellow) {
                    answer[0] = width;
                    answer[1] = height;
                    break;
                }
            }
        }

        return answer;
    }
}
