#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
	int answer = 0;
	int N = board[0].size();
	vector<int> basket;

	// 1. 바구니에 넣기
	for (int i = 0; i < moves.size(); i++) {
		for (int j = 0; j < N; j++) {
			int a = moves[i] - 1;
			if (board[j][a] == 0) continue;
			basket.push_back(board[j][a]);
			board[j][a] = 0;
			break;
		}

		// 2. 바구니 체크
		int k = basket.size();
		if ((k > 1) && (basket[k - 1] == basket[k - 2])) {
			basket.pop_back();
			basket.pop_back();
			answer += 2;
		}
	}

	return answer;
}

int main() {
	vector<vector<int>> board = { {0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1} };
	vector<int> moves = { 1,5,3,5,1,2,1,4 };
	printf("%d", solution(board, moves));
	return 0;
}