#include <stdio.h>

int main()
{
	int N, result = 0;
	char c[100] = { 0, };

	scanf("%d", &N);
	scanf("%s", c);

	for (int i = 0; i < N; i++)
	{
		result += c[i] - '0';	// ���ڸ� ���ڷ�
	}

	printf("%d", result);

	return 0;
}