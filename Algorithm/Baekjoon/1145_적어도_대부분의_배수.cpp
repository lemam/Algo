#include <iostream>
#include <algorithm>
using namespace std;

int main() {
	int num[5];
	int mul = 1, cnt = 0;

	for (int i = 0; i < 5; i++)
		cin >> num[i];

	while (1)
	{
		cnt = 0;
		for (int i = 0; i < 5; i++)
		{
			if (mul >= num[i] && mul % num[i] == 0)
				cnt++;
		}
		if (cnt >= 3)
			break;
		mul++;
	}
	cout << mul;
	return 0;
}