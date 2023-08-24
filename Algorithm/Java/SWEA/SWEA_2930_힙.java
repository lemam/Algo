import java.util.Scanner;

/*
 * SWEA 2930번 - 힙
 * 
 * 힙(Heap)은 최댓값 혹은 최솟값을 찾아내는 연산을 빠르게 하기 위해 고안된 자료구조이다.
 * 
 * 완전이진트리(Complete binary tree)를 기본으로 한 자료구조로서 다음과 같은 힙 속성(property)을 만족한다.
 * - A가 B의 부모노드(parent node) 이면, A의 키(key)값과 B의 키값 사이에는 항상 일정한 대소관계가 성립한다.
 * 
 * 키값의 대소관계는 오로지 부모노드와 자식노드 간에만 성립하며, 형제노드 사이에서는 일정한 대소관계가 정해지지 않는다.
 * 부모노드의 키값이 자식노드의 키값보다 항상 크거나 같은 힙을 '최대 힙', 
 * 부모노드의 키값이 자식노드의 키값보다 항상 작거나 같은 힙을 '최소 힙'이라고 부른다.
 * 
 * 힙의 루트노드(root node)는 힙을 구성하는 노드의 키값 중 최댓값 혹은 최솟값을 가지게 된다.
 * 
 * 본 문제에서는 최대 힙(max heap)을 올바르게 구현하였는지 확인할 수 있다.
 * 초기에 최대 힙이 비어있을 때에 다음의 2가지 연산을 수행하는 프로그램을 작성하자.
 * 연산 1. 자연수 x를 삽입
 * 연산 2. 최대 힙의 루트 노드의 키값을 출력하고, 해당 노드를 삭제
 * 
 * 만약 가장 큰 키값이 여러 개일 경우에는,
 * 삭제할 때에 그 키값을 가지는 노드들 전부가 삭제되는 것이 아니라, 루트 노드 단 하나만 삭제됨에 주의한다.
 * 
 * 만약, 연산 2를 수행해야 하는데 힙에 원소가 없어서 출력해야 할 최대 키값이 존재하지 않는다면 -1을 출력한다.
 */

public class SWEA_2930_힙 {
	public static int[] heap;
	public static int heapSize = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt(); // 테스트 케이스

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt(); // 수행해야하는 연산의 수
			heap = new int[N + 1];
			heapSize = 0;

			System.out.print("#" + tc + " ");

			// 연산 수행
			for (int i = 0; i < N; i++) {
				int command = sc.nextInt();

				// 1 이면 x를 최대 힙에 추가
				if (command == 1) {
					int x = sc.nextInt();
					heapPush(x);
				}
				// 2 이면 현재 최대 힙의 루트 노드의 키값을 출력, 해당 노드 삭제
				else if (command == 2) {
					System.out.print(heapPop() + " ");
				}
			}

			System.out.println();
		}

		sc.close();
	}

	// 힙에 최대 노드를 삭제하고 그 값을 반환한다.
	public static int heapPop() {
		// 최대 키가 존재하지 않으면 -1 출력
		if (heapSize == 0)
			return -1;

		int num = heap[1]; // 루트 노드의 데이터

		// 마지막 노드를 루트 노드에 넣는다.
		heap[1] = heap[heapSize--];

		int parent = 1;
		int child = parent * 2; // 왼쪽 자식 노드 번호

		// 오른쪽 자식 노드가 있으면
		if (child + 1 <= heapSize) {
			// 오른쪽 자식 노드와 왼쪽 자식 노드 중 값이 큰 자식 노드를 선택한다.
			child = (heap[child] < heap[child + 1]) ? child + 1 : child;
		}

		while (child <= heapSize && heap[parent] < heap[child]) {
			int temp = heap[child];
			heap[child] = heap[parent];
			heap[parent] = temp;

			// 부모 노드를 자식 노드로 이동
			parent = child;
			child = parent * 2;

			// 오른쪽 자식 노드가 있으면
			if (child + 1 <= heapSize) {
				// 오른쪽 자식 노드와 왼쪽 자식 노드 중 값이 큰 자식 노드를 선택한다.
				child = (heap[child] < heap[child + 1]) ? child + 1 : child;
			}
		}

		return num;
	}

	// 힙에 노드 추가
	public static void heapPush(int item) {
		// 마지막 노드에 추가
		heap[++heapSize] = item;

		int child = heapSize;
		int parent = child / 2;

		while (parent > 0 && heap[child] > heap[parent]) {
			int temp = heap[child];
			heap[child] = heap[parent];
			heap[parent] = temp;

			// 자식 노드를 부모 노드로 이동
			child = parent;
			parent = child / 2;
		}
	}
}
