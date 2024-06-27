package Programmers;

public class Pro_신규_아이디_추천 {
    public String solution(String new_id) {
        String answer = new_id;

        // 1. 대문자를 소문자로 치환한다.
        answer = answer.toLowerCase();

        // 2. 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거한다.
        answer = answer.replaceAll("[^a-z0-9-_.]", "");

        // 3. 연속된 마침표(.)을 한 개로 치환한다.
        while (answer.contains(".."))
            answer = answer.replace("..", ".");

        // 4. 마침표(.)가 처음이나 끝에 위치한다면 제거한다.
        if (answer.charAt(0) == '.')
            answer = answer.substring(1);

        if (!answer.isEmpty() && answer.charAt(answer.length() - 1) == '.') // 끝 문자를 볼 때 빈 문자열인지 확인
            answer = answer.substring(0, answer.length() - 1);

        // 5. 빈 문자열이라면, a를 대입한다.
        if (answer.isEmpty()) answer = "a";

        // 6. 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거한다.
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);

            // 마지막 문자가 마침표(.)이면 삭제한다.
            if (answer.charAt(answer.length() - 1) == '.')
                answer = answer.substring(0, answer.length() - 1);
        }

        // 7. 길이가 2자 이하이면, 마지막 문자를 길이가 3이 될 때까지 반복해서 끝에 붙인다.
        char endWord = answer.charAt(answer.length() - 1);

        while (answer.length() < 3) {
            answer += endWord;
        }

        return answer;
    }
}
