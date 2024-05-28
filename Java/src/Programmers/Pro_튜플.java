package Programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Pro_튜플 {
	public static void main(String[] args) {
		String s = "{{20,111},{111}}";

		int[] answer = solution(s);
		System.out.println(Arrays.toString(answer));
	}

	public static int[] solution(String s) {
		ArrayList<Integer> list = new ArrayList<>();

		// 앞의 '{{' 제거
		String str = s.substring(2);
		
		// 뒤의 '}}' 제거 후 '},{' 를 '/' 로 변환
		str = str.substring(0, str.length() - 2).replace("},{", "/");
		
		// '/' 을 기준으로 문자열을 나눈다.
		String[] arr = str.split("/");
		
		// 배열의 원소인 문자열의 길이를 기준으로 오름차순 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});
		
		// 문자열 탐색
		for (String item : arr) {
			// ',' 를 기준으로 문자열을 나눈다.
			String[] temp = item.split(",");
			
			// 집합 속 숫자를 탐색하여 중복없이 list에 저장
			for (int i = 0; i < temp.length; i++) {
				int num = Integer.parseInt(temp[i]);
				if (!list.contains(num)) {
					list.add(num);
				}
			}
		}
		
		// 리스트를 배열로 변환
		int listSize = list.size();
		int[] answer = new int[listSize];
		
		for (int i = 0; i < listSize; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
