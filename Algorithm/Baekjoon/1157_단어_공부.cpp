#include <stdio.h>

int main() {
	char S[1000000];	// 단어
	int list[26] = { 0, };	// 알파벳 사용 횟수
	int result[2] = { 0, };	// 최댓값 알파벳 인덱스 / 다수인지 확인
	int max = -1;	// 사용 횟수 최댓값
	scanf("%s", S);

	int size = sizeof(S) / sizeof(S[0]);
	for (int i = 0; i < size; i++)
	{
		// 알파벳 사용 횟수
		int idx = 0;
		if (S[i] == NULL)
			break;
		else if (S[i] >= 'A' && S[i] <= 'Z')
			idx = S[i] - 'A';
		else if (S[i] >= 'a' && S[i] <= 'z')
			idx = S[i] - 'a';

		list[idx]++;
	}

	// 최댓값 찾기
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

	// 다수일 경우
	if (result[1] != 0)
		printf("?");
	else
		printf("%c", result[0] + 'A');

	return 0;
}