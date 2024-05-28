#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string new_id) {
	string answer = "";

	// 1단계
	transform(new_id.begin(), new_id.end(), new_id.begin(), ::tolower);

	for (int i = 0; i < new_id.length(); i++) {
		// 2단계
		if ((new_id[i]>= 'a' && new_id[i] <= 'z') ||
			(new_id[i] >= '0' && new_id[i] <= '9') ||
			new_id[i] == '-' || new_id[i] == '_' || new_id[i] == '.')
		{
			answer += new_id[i];
		}
	}

	// 3단계
	for (int i = 1; i < answer.length();)
	{
		if (answer[i] == '.' && answer[i - 1] == '.')
		{
			answer.erase(answer.begin() + i);
			continue;
		}
		i++;
	}

	// 4단계
	while (!answer.empty())
	{
		if (answer.front() == '.')
			answer.erase(0, 1);
		else if (answer.back() == '.')
			answer.pop_back();
		else
			break;
	}

	// 5단계
	if (answer.empty())
		answer = "a";

	// 6단계
	if (answer.length() >= 16) {
		answer.resize(15);
		if (answer.back() == '.')
			answer.pop_back();
	}

	// 7단계
	if (answer.length() <= 2) {
		while (answer.length() < 3)
			answer.push_back(*(answer.end() - 1));
	}

	return answer;
}

int main() {
	string new_id = "...!@BaT#*..y.abcdefghijklm";
	//string new_id = "z-+.^.";
	//string new_id = "=.=";
	//string new_id = "123_.def"	;
	//string new_id = "abcdefghijklmn.p";
	string answer = solution(new_id);
	printf("%s", answer.c_str());
}