#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
	vector<int> answer;
	int count[201] = { 0, };

	for (int i = 0; i < numbers.size() - 1; i++)
	{
		for (int j = i + 1; j < numbers.size(); j++)
		{
			int n = numbers[i] + numbers[j];
			count[n]++;
		}
	}

	for (int i = 0; i < 201; i++)
	{
		if (count[i] > 0)
			answer.push_back(i);
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