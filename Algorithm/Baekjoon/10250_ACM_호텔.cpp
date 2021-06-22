#include <iostream>

void assign(int H, int W, int N)
{
	int X, Y;	// floor : Y, number : X

	X = (N % H == 0) ? N / H : N / H + 1;
	Y = (N % H == 0) ? H : N % H;

	printf("%d%02d\n", Y, X);
}

int main()
{
	int T, H, W, N;

	std::cin >> T;

	for (int i = 0; i < T; i++)
	{
		std::cin >> H >> W >> N;
		assign(H, W, N);
	}

	return 0;
}