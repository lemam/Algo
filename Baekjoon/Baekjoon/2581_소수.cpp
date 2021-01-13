#include <iostream>

int main()
{
	int M, N, sum = 0, min = 0;

	std::cin >> M >> N;

	int size = N - M + 1;

	for (int i = 0; i < size; i++)
	{
		int p = M + i;
		int j = 2;

		if (p == 1)
			continue;
		if (p == 2)
		{
			sum += p;
			min = p;
			continue;
		}

		for (j; j < p; j++)
		{
			if (p % j == 0)
				break;
		}

		if (p == j)
		{
			if (min == 0)
				min = p;
			sum += p;
		}
	}
	if (sum == 0 && min == 0)
		std::cout << -1;
	else
		std::cout << sum << std::endl << min;
	
	return 0;
}