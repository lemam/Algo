#include <iostream>

void factor(int n)
{
	if (n == 1)
		return;

	int i = 2;
	while (i != n)
	{
		for (i = 2; i < n; i++)
		{
			if (n % i == 0)
			{
				n /= i;
				std::cout << i << std::endl;
				break;
			}
		}
	}
	std::cout << n;
}

int main()
{
	int N;
	std::cin >> N;
	factor(N);

	return 0;
}