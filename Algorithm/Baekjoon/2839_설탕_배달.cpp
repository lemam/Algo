#include <iostream>

int main() {
	int N, cnt = 0;
	std::cin >> N;

	// 5�� ����� ���� ������ -3
	// 0 ���ϰ� �Ǹ� return -1
	while (true)
	{
		if (N < 0)
		{
			cnt = -1;
			break;
		}
		if (N % 5 == 0)
		{
			cnt += N / 5;
			break;
		}
		N -= 3;
		cnt++;
	}
	std::cout << cnt;

	return 0;
}