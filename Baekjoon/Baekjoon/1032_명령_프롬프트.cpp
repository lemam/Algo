#include <iostream>
using namespace std;

int main()
{
	int N;
	string str, result;

	cin >> N;
	cin >> str;
	result = str;

	for (int i = 0; i < N - 1; i++)
	{
		cin >> str;
		for (int j = 0; j < str.length(); j++)
		{
			if (str.at(j) != result.at(j))
				result.at(j) = '?';
		}
	}

	cout << result;

	return 0;
}