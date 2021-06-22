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
			// key ���� �ߺ��� ������ ����
			// ���Ҵ� �ڵ����� ���� (��������)
			s.insert(numbers[i] + numbers[j]);
		}
		// ���� ��ü�� �ִ� ���ҵ��� ��� �����ϰ� ���ڸ� ���� ����.
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