#include <stdio.h>
#include <string.h>

int main()
{
	char str[1000000];
	// %[] []���� ���ڰ� �ƴϸ� �Է��� �����Ѵ�.
	scanf("%[^\n]", str);	// %[^\n] \n�� ������ ��� ������ �޴´�.
	int cnt = 0;

	char* token = strtok(str, " ");	// " "���� �������� �ڸ�, ������ ��ȯ
	while (token != NULL)	// �ڸ� ���ڿ��� ������ ���� ������
	{
		cnt++;
		token = strtok(NULL, " ");	// ���� ���ڿ� �߶� ������ ��ȯ
	}
	printf("%d", cnt);

	return 0;
}