#include <stdio.h>

int main() {
	char x[4], y[4];
	scanf("%s %s", x, y);

	// ���� �Ųٷ� �ٲٰ� ū �� ���
	for (int i = 2; i >= 0; i--)
	{
		if (x[i] > y[i])
		{
			for (int j = 2; j >= 0; j--)
			{
				printf("%c", x[j]);
			}
			break;
		}
		else if (x[i] < y[i])
		{
			for (int j = 2; j >= 0; j--)
			{
				printf("%c", y[j]);
			}
			break;
		}
		else continue;
	}

	return 0;
}