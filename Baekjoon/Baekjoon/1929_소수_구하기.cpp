#include <iostream>
using namespace std;

int p[1000001] = { 0, };

// �����佺�׳׽��� ü ����
void prime(int m, int n)
{
	// M �̻� N ���� �Ҽ� ���ϱ�
	for (int i = m; i <= n; i++)
	{
		p[i] = i;
	}

	// ó�� ���ڸ� ������ ��� ���� (2����)
	p[1] = 0;
	for (int i = 2; i <= n; i++)
	{
		for (int j = 2 * i; j <= n; j += i)
			p[j] = 0;
	}

	// ���
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