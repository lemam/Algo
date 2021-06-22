#include <iostream>

int main()
{
	int A, B, V;
	int day = 1;

	std::cin >> A >> B >> V;

	if ((V - A) % (A - B) == 0)
		day += (V - A) / (A - B);
	else
		day += (V - A) / (A - B) + 1;
		
	std::cout << day;

	return 0; 
}