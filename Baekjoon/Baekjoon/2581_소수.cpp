#include <iostream>
#include <math.h>

bool isPrime(int n)
{
	if (n <= 1)
		return false;

	for (int i = 2; i <= sqrt(n); i++)	// 소수 구하기*
	{
		if ((n % i) == 0)
			return false;
	}

	return true;
}

int main()
{
	int M, N, sum = 0, min = 0;

	std::cin >> M >> N;

	for (int i = M; i <= N; i++)
	{
		if (isPrime(i))
		{
			if (min == 0)
				min = i;
			sum += i;
		}
	}
	if (sum)
		std::cout << sum << std::endl << min;
	else
		std::cout << "-1";

	return 0;
}