#include <iostream>
using namespace std;

int p[1000001] = { 0, };

// 에라토스테네스의 체 원리
void prime(int m, int n)
{
	// M 이상 N 이하 소수 구하기
	for (int i = m; i <= n; i++)
	{
		p[i] = i;
	}

	// 처음 숫자를 제외한 배수 제거 (2부터)
	p[1] = 0;
	for (int i = 2; i <= n; i++)
	{
		for (int j = 2 * i; j <= n; j += i)
			p[j] = 0;
	}

	// 출력
	for (int i = 2; i <= n; i++)
	{
		if (p[i] != 0)
			cout << p[i] << '\n';
	}
}

int main()
{
	int M, N;
	cin >> M >> N;

	prime(M, N);
	return 0;
}