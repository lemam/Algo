import java.util.Scanner;

/*
 * SWEA 1231번 - 중위순회 (D4)
 * 
 * 주어진 트리를 in-order 형식으로 순회해 각 노드를 읽으면 특정 단어를 알 수 있다.
 * 주어진 트리를 in-order 형식으로 순회했을때 나오는 단어를 출력하라.
 * 트리는 완전 이진 트리 형식으로 주어지며, 노드당 하나의 문자만 저장할 수 있다.
 */

public class SWEA_1231_중위순회 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
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

			System.out.print("#" + tc + " ");
			
			// 중위 순회 출력
			inorder(tree, 1);
			
			System.out.println();
		}

		sc.close();
	}

	// 중위 순회
	public static void inorder(String[] tree, int i) {
		if (i < tree.length && tree[i] != null) {
			inorder(tree, 2 * i);
			System.out.print(tree[i]);
			inorder(tree, 2 * i + 1);
		}
	}
}
