#include <iostream>
#include <algorithm>
using namespace std;

void print(int max, int a, int b)
{
	if (max * max == (a * a) + (b * b))
		cout << "right\n";
	else
		cout << "wrong\n";
}

int main()
{
	while (1)
	{
		int num[3];
		cin >> num[0] >> num[1] >> num[2];

		if (num[0] <= 0 && num[1] <= 0 && num[2] <= 0)
			break;
		
		int maxNum = num[0];
		for (int i = 0; i < 3; i++)
			maxNum = max(maxNum, num[i]);

		if (maxNum == num[0])
			print(maxNum, num[1], num[2]);
		else if (maxNum == num[1])
			print(maxNum, num[0], num[2]);
		else
			print(maxNum, num[0], num[1]);
	}

	return 0;
}