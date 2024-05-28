#include <stdio.h>
#include <string.h>

void f(int R, char* S)	// 한 문자씩 R번 출력
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
	int T;	// 테스트 케이스
	scanf("%d", &T);

	for (int t = 0; t < T; t++)
	{
		int R;	// 반복횟수
		char S[20];	// 문자열

		scanf("%d", &R);
		scanf("%s", &S);

		f(R, S);
	}
	return 0;
}