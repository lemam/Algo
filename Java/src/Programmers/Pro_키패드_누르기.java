package Programmers;

public class Pro_키패드_누르기 {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();

        // 오른손, 왼손 엄지손가락 위치
        int right = 10;
        int left = 12;

        for (int number : numbers) {
            // 숫자가 1, 4, 7인 경우 왼손으로 누르고, 왼손의 위치를 이동한다.
            if (number == 1 || number == 4 || number == 7) {
                left = number;
                sb.append("L");
            }
            // 숫자가 3, 6, 9인 경우 오른손으로 누르고, 오른손의 위치를 이동한다.
            else if (number == 3 || number == 6 || number == 9) {
                right = number;
                sb.append("R");
            } else {
                // 숫자가 0인 경우 키패드 위치를 11로 변환
                if (number == 0) number = 11;

                // 손과 키패드 사이의 거리 구하기
                // 위아래로 3차이, 양옆으로 1차이인 것을 이용
                // 상하로 움직일 때 /3, 좌우로 움직일 때 %3
                int leftDiff = Math.abs(number - left) / 3 + Math.abs(number - left) % 3;
                int rightDiff = Math.abs(number - right) / 3 + Math.abs(number - right) % 3;

                // 두 손의 거리가 같은 경우
                if (leftDiff == rightDiff) {
                    // 오른손잡이인 경우 오른손 사용
                    if (hand.equals("right")) {
                        right = number;
                        sb.append("R");
                    }
                    // 왼손잡이인 경우 왼손 사용
                    else {
                        left = number;
                        sb.append("L");
                    }
                }
                // 더 가까운 손으로 누른다.
                else if (leftDiff > rightDiff) {
                    right = number;
                    sb.append("R");
                } else {
                    left = number;
                    sb.append("L");
                }
            }
        }

        return sb.toString();
    }
}
