#include <stdio.h>
#include <string.h>

void f(int R, char* S)	// �� ���ھ� R�� ���
{
	for (int i = 0; i < strlen(S); i++)
	{
		for (int j = 0; j < R; j++)
		{
			printf("%c", S[i]);
		}
	}
	printf("\n");
}

int main()
{
	int T;	// �׽�Ʈ ���̽�
	scanf("%d", &T);

	for (int t = 0; t < T; t++)
	{
		int R;	// �ݺ�Ƚ��
		char S[20];	// ���ڿ�

		scanf("%d", &R);
		scanf("%s", &S);

		f(R, S);
	}
	return 0;
}