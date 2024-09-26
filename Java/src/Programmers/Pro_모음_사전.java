package Programmers;

class Pro_모음_사전 {
    public int solution(String word) {
        int[] rateOfIncrease = {781, 156, 31, 6, 1};    // 각 자리수에서 만들 수 있는 단어의 수 (f(4) ~ f(0))
        String vowels = "AEIOU";    // 알파벳 모음 (사전순)
        int answer = word.length(); // 단어의 길이로 초기화 (A를 0번째로 봤지만 실제로는 1부터 시작하기 때문에)

        for (int i = 0; i < word.length(); i++) {
            int idx = vowels.indexOf(word.charAt(i));   // 현재 문자가 몇 번째 인덱스의 모음인지 저장
            answer += rateOfIncrease[i] * idx;  // (4-i)번째 자리수에서 만들 수 있는 단어의 수 * 인덱스 = 스킵할 단어들의 수
        }

        return answer;
    }
}
