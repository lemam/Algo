#include <iostream>

int main()
{
	int N;
	int max = 1;	// 類曖 葆雖虞 璋濠
	int floor = 1;	// 類
	std::cin >> N;

	// N曖 類 熱
	while (N > max)	
	{
		max += floor * 6;
		floor++;
	}

	std::cout << floor;
	return 0;
}