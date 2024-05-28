#include <iostream>
using namespace std;

int main() {
	int N, F;
	cin >> N >> F;

	for (N, F, N -= N % 100; N % F; N++);
	printf("%02d", N % 100);

	return 0;
}