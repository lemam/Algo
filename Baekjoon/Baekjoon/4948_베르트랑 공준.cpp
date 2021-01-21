#include <iostream>
using namespace std;

int main()
{
	bool list[246913] = { 0, };
	int n, cnt;

	while (true)
	{
		cin >> n;
		cnt = 0;

		if (n == 0)
			break;

		for (int i = n + 1; i <= 2 * n; i++)
		{
			list[i] = true;
		}

		for (int i = 2; i <= 2 * n; i++)
		{
			for (int j = 2 * i; j <= 2 * n; j += i)
			{
				list[j] = false;
			}
		}
		
		for (int i = n + 1; i <= 2 * n; i++)
			if (list[i]) cnt++;

		cout << cnt << "\n";
	}
	return 0;
}