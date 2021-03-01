#include <iostream>
using namespace std;

int main()
{
	int T;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		int a, b;
		cin >> a >> b;

		long result = a % 10;
		if (b >= 4)		// 최대 4주기마다 같은 숫자 반복
			b = b % 4 + 4;

		for (int i = 2; i <= b; i++)
			result = (result * a) % 10;
		
		if (result == 0)
			cout << "10\n";
		else
			cout << result << "\n";
	}

	return 0;
}