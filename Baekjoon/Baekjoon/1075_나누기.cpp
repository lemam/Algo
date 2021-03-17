#include <iostream>
#include <string>
using namespace std;

int main() {
	string N;
	int F;
	cin >> N >> F;

	N[N.length() - 1] = '0';
	N[N.length() - 2] = '0';

	long n = stol(N);
	if (n % F == 0)
		cout << "00\n";
	else
	{
		N = to_string(((n / F) + 1) * F);
		cout << N[N.length() - 2] << N[N.length() - 1] << "\n";
	}

	return 0;
}