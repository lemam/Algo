#include <iostream>

int main()
{
	int N, n;
	int cnt = 0;

	std::cin >> N;
	for (int i = 0; i < N; i++)
	{
		int j = 2;
		std::cin >> n;

		if (n == 1)
			continue;
		if (n == 2)
		{
			cnt++;
			continue;
		}

		for (j = 2; j < n; j++)
		{
			if (n % j == 0)
				break;
		}
		if (n == j) cnt++;
	}
	std::cout << cnt;

	return 0;
}