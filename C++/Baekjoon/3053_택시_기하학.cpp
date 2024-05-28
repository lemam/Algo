#include <iostream>
#include <math.h>
#define PI 3.1415926535897932

int main()
{
	int R;
	std::cin >> R;

	printf("%.6f\n", PI * pow(R, 2));
	printf("%.6f\n", 2 * pow(R, 2));
	
	return 0;
}