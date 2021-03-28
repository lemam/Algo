#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
	int answer = 0;
	vector<int> basket;

	for (int i = 0; i < moves.size(); i++) {
		for (int j = 0; j < board.size(); j++) {
			int idx = moves[i] - 1;
			if (board[j][idx] == 0) continue;

			if (!basket.empty() && basket.back() == board[j][idx]) {
				basket.pop_back();
				answer += 2;
			}
			else
				basket.push_back(board[j][idx]);

			board[j][idx] = 0;
			break;
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