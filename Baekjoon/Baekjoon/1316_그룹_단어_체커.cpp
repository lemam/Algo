#include <iostream>

int T;	// 테스트 케이스
char str[100];	// input
int cnt = 0;	// output

// 그룹 단어 체크
bool groupCheck()	
{
	int al[26] = { 0, };	// 나온 알파벳 횟수
	char c = '\0';
	int size = sizeof(str) / sizeof(str[0]);
	for (int i = 0; i < size; i++)
	{
		if (str[i] == NULL)
			break;
		if (c != str[i])
		{
			al[str[i] - 'a']++;
			c = str[i];
		}
	}

	for (int n : al)
	{
		if (n > 1)	// 두 번 이상 나오면 그룹 단어 아님
			return false;
	}
	return true;
}

int main()
{
	std::cin >> T;
	for (int t = 0; t < T; t++)
	{
		std::cin >> str;
		if (groupCheck())
			cnt++;
	}
	std::cout << cnt;	

	return 0;
}