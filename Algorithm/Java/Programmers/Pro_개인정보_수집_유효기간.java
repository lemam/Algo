import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pro_개인정보_수집_유효기간 {
	public static int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answerList = new ArrayList<Integer>();
		int tDate = getDate(today);

		// 약관 정보를 Map에 저장한다.
		Map<String, Integer> termMap = new HashMap<String, Integer>();

		for (String term : terms) {
			String[] arr = term.split(" ");
			termMap.put(arr[0], Integer.parseInt(arr[1]));
		}

		// 개인정보 배열 탐색
		for (int i = 0; i < privacies.length; i++) {
			String[] privacyArr = privacies[i].split(" ");
			int pDate = getDate(privacyArr[0]);
			String type = privacyArr[1]; // 약관 종류

			// 해당 약관의 유효기간을 개인정보 수집 일자에 더한다.
			pDate += termMap.get(type) * 28;

			// 개인정보 수집 일자가 오늘 날짜로 유효하면 개인정보 번호를 저장한다.
			if (pDate <= tDate) {
				answerList.add(i + 1);
			}
		}

		// List를 배열로 변환한다.
		int len = answerList.size();
		int[] answer = new int[len];

		for (int i = 0; i < len; i++) {
			answer[i] = answerList.get(i);
		}

		return answer;
	}

	private static int getDate(String dateStr) {
		String[] arr = dateStr.split("\\.");
		int year = Integer.parseInt(arr[0]);
		int month = Integer.parseInt(arr[1]);
		int day = Integer.parseInt(arr[2]);

		return (year * 12 * 28) + (month * 28) + day;
	}
}
