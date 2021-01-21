#include <iostream>

bool list[123456 * 2 + 1];
int n, n2 = 123456 * 2 + 1;

int main() 
{
	list[0] = list[1] = 1;

	// list 초기화
	for (int i = 2; i * i <= n2; i++)
	{
		if (!list[i])
		{
			// 소수의 배수 제거
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
		
		// 0 입력시 종료
		if (n == 0)
			break;

		// n 초과 2n 이하 소수의 개수 출력
		for (int i = n + 1; i <= 2 * n; i++)
		{
			if (!list[i])
				cnt++;
		}
		std::cout << cnt << "\n";
	}
}