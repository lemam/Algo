#include <iostream>

int main() {
	int N, cnt = 0;
	std::cin >> N;

	// 5의 배수가 나올 때까지 -3
	// 0 이하가 되면 return -1
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