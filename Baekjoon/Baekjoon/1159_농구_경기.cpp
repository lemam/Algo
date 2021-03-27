#include <iostream>
using namespace std;

int main() {
	int a[26] = { 0, }, N, i;
	string d;

	cin >> N;
	while (N--) {
		cin >> d;
		a[d[0] - 'a']++;
	}

	for (int i = 0; i < 26; i++) {
		if (a[i] >= 5) {
			cout << (char)(i + 'a');
			N++;
		}
	}
	if (N < 0) {
		cout << "PREDAJA";
	}

	return 0;
}