import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BOJ_10816_숫자_카드_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자 카드의 개수
		String[] cards = br.readLine().split(" "); // 숫자 카드에 적혀있는 정수 배열

		Map<String, Integer> map = new HashMap<String, Integer>(); // 숫자 카드 정수, 개수

		// 카드 개수를 저장한다.
		for (int i = 0; i < N; i++) {
			if (map.containsKey(cards[i])) {
				map.put(cards[i], map.get(cards[i]) + 1);
			} else {
				map.put(cards[i], 1);
			}
		}

		int M = Integer.parseInt(br.readLine());
		String[] having = br.readLine().split(" "); // 상근이가 몇 개 가지고 있는 숫자 카드인지 구해야 할 M개의 정수 배열

		int[] answer = new int[M]; // 정답을 저장할 배열

		// 상근이가 가지고 있는 숫자 카드이면 그 개수를 answer에 저장한다.
		for (int i = 0; i < M; i++) {
			if (map.containsKey(having[i])) {
				answer[i] = map.get(having[i]);
			}
		}

		// 정답을 출력한다.
		for (int i = 0; i < M; i++) {
			sb.append(answer[i] + " ");
		}

		System.out.println(sb);

		br.close();
	}
}
