#include <iostream>

bool list[123456 * 2 + 1];
int n, n2 = 123456 * 2 + 1;

int main() 
{
	list[0] = list[1] = 1;

	// list �ʱ�ȭ
	for (int i = 2; i * i <= n2; i++)
	{
		if (!list[i])
		{
			// �Ҽ��� ��� ����
			for (int j = i * i; j <= n2; j += i)
			{
				list[j] = 1;
			}
		}
	}

	while (true)
	{
		int cnt = 0;
		std::cin >> n;
		
		// 0 �Է½� ����
		if (n == 0)
			break;

		// n �ʰ� 2n ���� �Ҽ��� ���� ���
		for (int i = n + 1; i <= 2 * n; i++)
		{
			if (!list[i])
				cnt++;
		}
		std::cout << cnt << "\n";
	}
}