#include <iostream>

using namespace std;

int main() {

	string strA, strB;
	cin >> strA >> strB;

	int lenA = strA.length();
	int lenB = strB.length();
	long long result = 0;

	for (int i = 0; i < lenA; i++) {
		for (int j = 0; j < lenB; j++) {
			result += (strA[i] - '0') * (strB[j] - '0');
		}
	}

	cout << result;

	return 0;
}