import java.io.IOException;
import java.util.Scanner;

/*
 * SWEA 1231번 - 중위순회 (D4)
 * 
 * 주어진 트리를 in-order 형식으로 순회해 각 노드를 읽으면 특정 단어를 알 수 있다.
 * 주어진 트리를 in-order 형식으로 순회했을때 나오는 단어를 출력하라.
 * 
 * 정점 번호는 1부터 N까지의 정수로 구분된다. 
 * 루트 정점의 번호는 항상 1이다.
 */

public class SWEA_1231_중위순회 {
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		sb = new StringBuilder();

		int T = 10; // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(sc.nextLine()); // 정점의 총 수
			String[] tree = new String[N + 1]; // 트리 배열

			// 트리 정점 입력
			for (int i = 0; i < N; i++) {
				String[] str = sc.nextLine().split(" ");

				int num = Integer.parseInt(str[0]); // 정점 번호
				String word = str[1]; // 노드 데이터

				tree[num] = word;
			}

			sb.append("#" + tc + " ");

			// 중위 순회
			inorder(tree, 1);

			sb.append("\n");
		}

		System.out.println(sb);
		sc.close();
	}

	private static void inorder(String[] tree, int idx) {
		if (idx < tree.length && tree[idx] != null) {
			inorder(tree, idx * 2); // 왼쪽 확인
			sb.append(tree[idx]); // 노드 출력
			inorder(tree, idx * 2 + 1); // 오른쪽 확인
		}
	}
}
