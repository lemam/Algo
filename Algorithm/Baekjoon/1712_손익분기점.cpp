#include <iostream>

int main() {
	int A, B, C;
	int N;
	std::cin >> A >> B >> C;

	// A + B*N < C*N
	if (C > B)
	{
		N = (A / (C - B)) + 1;
		std::cout << N;
	}
	else
		std::cout << -1;

	return 0;
}