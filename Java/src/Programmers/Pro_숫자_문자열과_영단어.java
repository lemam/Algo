package Programmers;

public class Pro_숫자_문자열과_영단어 {
    public static void main(String[] args) {
        solution("one4seveneight");
    }

    // 일부 자릿수를 영단어로 바꿈
    // 원래 숫자를 찾는 게임

    private static String[] list = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    public static int solution(String s) {
        String answer = s;

        for (int i = 0; i < list.length; i++) {
            answer = answer.replaceAll(list[i], i + "");
        }

        return Integer.parseInt(answer);
    }
}
