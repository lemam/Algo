#include <iostream>

int main()
{
	int N;
	int max = 1;	// ���� ������ ����
	int floor = 1;	// ��
	std::cin >> N;

	// N�� �� ��
	while (N > max)	
	{
		max += floor * 6;
		floor++;
	}

	std::cout << floor;
	return 0;
}