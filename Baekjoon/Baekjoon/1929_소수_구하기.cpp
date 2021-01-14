#include <iostream>
#include <math.h>
using namespace std;

int d[] = { 2, 3, 5 ,7 };

bool prime(int n)
{
	if (n < 10)
	{
		for (int i = 0; i < 4; i++)
		{
			if (n == d[i])
				return true;
		}
	}
	else
	{
		for (int i = 0; i < 4; i++)
		{
			if (n % d[i] == 0)
				return false;
		}
		return true;
	}
	return false;
}

int main()
{
	int M, N;
	cin >> M >> N;

	for (int i = M; i <= N; i++)
	{
		if (prime(i))
			cout << i << endl;
	}
	return 0;
}