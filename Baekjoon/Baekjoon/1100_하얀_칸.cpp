#include <iostream>
using namespace std;

int main() {
	string line;
	int cnt = 0;

	for (int i = 0; i < 8; i++) {
		cin >> line;
		for (int j = 0; j < 8; j++) {
			if ((line[j] == 'F') && ((i + j) % 2 == 0))
				cnt++;
		}
	}
	cout << cnt;
	return 0;
}