#include <stdio.h>
#include <string.h>

int main()
{
	char str[1000000];
	// %[] []안의 문자가 아니면 입력을 종료한다.
	scanf("%[^\n]", str);	// %[^\n] \n를 제외한 모든 문자을 받는다.
	int cnt = 0;

	char* token = strtok(str, " ");	// " "문자 기준으로 자름, 포인터 반환
	while (token != NULL)	// 자른 문자열이 나오지 않을 때까지
	{
		cnt++;
		token = strtok(NULL, " ");	// 다음 문자열 잘라서 포인터 반환
	}
	printf("%d", cnt);

	return 0;
}