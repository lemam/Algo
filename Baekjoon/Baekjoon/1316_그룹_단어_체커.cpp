#include <iostream>

int T;	// �׽�Ʈ ���̽�
char str[100];	// input
int cnt = 0;	// output

// �׷� �ܾ� üũ
bool groupCheck()	
{
	int al[26] = { 0, };	// ���� ���ĺ� Ƚ��
	char c = '\0';
	int size = sizeof(str) / sizeof(str[0]);
	for (int i = 0; i < size; i++)
	{
		if (str[i] == NULL)
			break;
		if (c != str[i])
		{
			al[str[i] - 'a']++;
			c = str[i];
		}
	}

	for (int n : al)
	{
		if (n > 1)	// �� �� �̻� ������ �׷� �ܾ� �ƴ�
			return false;
	}
	return true;
}

int main()
{
	std::cin >> T;
	for (int t = 0; t < T; t++)
	{
		std::cin >> str;
		if (groupCheck())
			cnt++;
	}
	std::cout << cnt;	

	return 0;
}