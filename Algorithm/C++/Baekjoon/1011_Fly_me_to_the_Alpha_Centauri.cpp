#include <iostream>
#include <math.h>

int main()
{
	int T;
	long x, y;

	std::cin >> T;
	for (int t = 0; t < T; t++)
	{
		std::cin >> x >> y;
		int d = y - x;
		int i = 1;
		for (i; ; i++)
			if(pow(i, 2) > d)
				break;

		if (pow(i - 1, 2) == d)	// �������� ���
			std::cout << 2 * (i - 2) + 1 << "\n";
		else if ((pow(i-1, 2) + pow(i, 2)) / 2 < d)	// ������ ���� �߰�
			std::cout << 2 * (i - 2) + 3 << "\n";
		else
			std::cout << 2 * (i - 2) + 2 << "\n";	// ������ �Ʒ�
	}
	return 0;
}