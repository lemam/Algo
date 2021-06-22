#include <iostream>

int resident[15][15] = { 0, };

void init();
void count(int k, int n);
void add(int k, int n);

int main()
{
	int T, k, n;

	init();
	std::cin >> T;
	for (int t = 0; t < T; t++)
	{
		std::cin >> k >> n;
		count(k, n);
		std::cout << resident[k][n] << std::endl;
	}

	return 0;
}

void init()
{
	int i = 1;
	for (int n = 1; n <= 14; n++)
		resident[0][n] = i++;
}

// 배열에 있는지 확인
void count(int k, int n)
{
	if (resident[k][n] == 0)
	{
		count(k - 1, n);
		add(k, n);
	}
}

// 배열에 추가
void add(int k, int n)
{
	for (int i = 1; i <= n; i++)
	{
		if (resident[k][i] != 0)
			continue;
		if (i == 1)
		{
			resident[k][i] = 1;
			continue;
		}
		resident[k][i] = resident[k][i - 1] + resident[k - 1][i];
	}
}