#include <stdio.h>

int main()
{
	char S[100];
	int result[26], n;
	scanf("%s", S);

	int size = sizeof(result) / sizeof(result[0]);
	for (int i = 0; i < size; i++)
		result[i] = -1;

	// ���ĺ��� ó�� ������ �ڸ�
	for (int i = 0; i < 100; i++)
	{
		if (S[i] == NULL)
			break;
		n = S[i] - 'a';	// ���ĺ� �ε���
		if (result[n] == -1)
			result[n] = i;
	}

	for (int i : result)
		printf("%d ", i);
	return 0;
}