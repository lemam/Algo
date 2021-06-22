#include <iostream>
#include <math.h>
using namespace std;

#define SIZE 10000

bool list[SIZE + 1];

// �����佺�׳׽��� ü
void Eratos()
{
	// �Ҽ� = false
	list[0] = list[1] = 1;

	for (int i = 2; i <= SIZE; i++)
	{
		if (!list[i])
		{
			for (int j = i * i; j <= SIZE; j += i)
			{
				list[j] = 1;
			}
		}
	}
}

// ������ ��Ƽ��
void Partition(int n)
{
	for (int i = n / 2; i >= 2; i--)
	{
		if (!list[i] && !list[n - i])
		{
			printf("%d %d\n", i, n - i);
			return;
		}
	}
}

int main()
{
	int T, n;

	cin >> T;
	Eratos();

	for (int t = 0; t < T; t++)
	{
		cin >> n;
		Partition(n);
	}

	return 0;
}