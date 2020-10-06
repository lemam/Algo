#include <stdio.h>

int main()
{
	int N;
	int cnt = 0;
	scanf("%d", &N);

	for (int i = 1; i <= N; i++)
	{
		if (i < 100)
		{
			cnt++;
			continue;
		}
		int h = i / 100;
		int t = (i % 100) / 10;
		int o = (i % 100) % 10;

		if ((h - t) == (t - o))	// 등차수열
			cnt++;
	}
	printf("%d", cnt);

	return 0;
}