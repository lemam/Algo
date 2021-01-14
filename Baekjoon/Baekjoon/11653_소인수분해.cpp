#include <iostream>

void factor(int n)
{
	int i = 2;
	for (i; i * i <= n;)
	{
		if (n % i == 0)
		{
			std::cout << i << std::endl;
			n /= i;
		}
		else
			i++;
	}

	if (n != 1)
		std::cout << n << std::endl;
}

int main()
{
	int N;
	std::cin >> N;

	if (N != 1)
		factor(N);

	return 0;
}