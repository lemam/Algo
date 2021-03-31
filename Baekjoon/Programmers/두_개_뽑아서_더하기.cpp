#include <string>
#include <vector>
#include <set>

using namespace std;

vector<int> solution(vector<int> numbers) {
	vector<int> answer;
	set<int> s;

	for (int i = 0; i < numbers.size(); i++) {
		for (int j = i + 1; j < numbers.size(); j++) {
			// set
			// key 값은 중복이 허용되지 않음
			// 원소는 자동으로 정렬 (오름차순)
			s.insert(numbers[i] + numbers[j]);
		}
		// 벡터 객체에 있는 원소들을 모두 삭제하고 인자를 집어 넣음.
		// void assign(InputIterator first, InputIterator last);
		// void assign(size_type n, const T & u);
		answer.assign(s.begin(), s.end());
	}

	return answer;
}

int main() {
	//vector<int> numbers = { 2,1,3,4,1 };
	vector<int> numbers = { 5,0,2,7 };

	vector<int> answer = solution(numbers);

	for (int i : answer)
		printf("%d ", i);

	return 0;
}