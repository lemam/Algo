#include <stdio.h>

int main() {
	char S[1000000];	// �ܾ�
	int list[26] = { 0, };	// ���ĺ� ��� Ƚ��
	int result[2] = { 0, };	// �ִ� ���ĺ� �ε��� / �ټ����� Ȯ��
	int max = -1;	// ��� Ƚ�� �ִ�
	scanf("%s", S);

	int size = sizeof(S) / sizeof(S[0]);
	for (int i = 0; i < size; i++)
	{
		// ���ĺ� ��� Ƚ��
		int idx = 0;
		if (S[i] == NULL)
			break;
		else if (S[i] >= 'A' && S[i] <= 'Z')
			idx = S[i] - 'A';
		else if (S[i] >= 'a' && S[i] <= 'z')
			idx = S[i] - 'a';

		list[idx]++;
	}

	// �ִ� ã��
	size = sizeof(list) / sizeof(list[0]);
	for (int i = 0; i < size; i++)
	{
		if (list[i] > max)
		{
			max = list[i];
			result[0] = i;
			result[1] = 0;
		}
		else if (list[i] == max)
		{
			result[1] = i;
		}
	}

	// �ټ��� ���
	if (result[1] != 0)
		printf("?");
	else
		printf("%c", result[0] + 'A');

	return 0;
}