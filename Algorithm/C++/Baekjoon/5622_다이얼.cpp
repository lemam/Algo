#include <stdio.h>

int main()
{
	char str[16];
	scanf("%s", str);
	int time = 0;

	for (int i = 0; i < 16; i++)
	{
		if (str[i] == NULL)
			break;
		
		int c = str[i] - 'A';	// ���ĺ� �ε���
		int n = 3;	// ��ټ��� �� ���ڴ� ���ĺ� 3��
		int t = 3;	// ���� 2���� A ����
		while (true)
		{
			if (n < 18)
			{
				if (c < n)
				{
					time += t;
					break;
				}
			}
			else	// 7 : PQRS, 9 : WXYZ
			{
				if (c <= n)
				{
					if (str[i] == 'Z')	// Z�� c = 25
						t = 10;
					time += t;
					break;
				}
			}
			n += 3;
			t++;
		}
	}
	printf("%d", time);

	return 0;
}