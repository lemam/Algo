#include <stdio.h>

int num[10001] = { 0, };

void d() {	// n�� n�� �� �ڸ����� ���ϴ� �Լ�
	int temp = 0;
	for (int i = 1; i < 10001; i++) {
		temp = i;
		int n = i;
		while (n != 0)
		{
			temp += n % 10;
			n /= 10;
		}
		num[temp]++;
	}
}

int main()
{
	d();
	int size = sizeof(num) / sizeof(num[0]);
	for (int i = 1; i < size; i++)
	{
		if (num[i] == 0)
			printf("%d\n", i);
	}

	return 0;
}