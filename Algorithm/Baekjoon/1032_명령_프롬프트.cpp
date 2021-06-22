#include <iostream>
using namespace std;

int main()
{
	int N;
	string str, result;

	cin >> N;
	cin >> result;
	int size = result.length();

	while (--N)
	{
		cin >> str;
		for (int i = 0; i < size; i++)
			if (result[i] != '?' && result[i] != str[i])
				result[i] = '?';
	}
	cout << result;

	return 0;
}