package Programmers;

import java.util.*;

class Pro_전화번호_목록 {
    public boolean solution(String[] phone_book) {
        // phone_book을 오름차순 정렬한다.
        Arrays.sort(phone_book);

        // 앞 번호가 뒷 번호의 접두어인지 확인한다.
        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}
