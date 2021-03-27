#include <iostream>
using namespace std;

int main() {
	string line;
	int cnt = 0;
	for (int i = 0; i < 8; i++) {
		cin >> line;
		for (int j = 0; j < 4; j++) {
			if (i % 2 != 0) {
				if (line.at(2 * j + 1) == 'F')
					cnt++;
			}
			else {
				if (line.at(2 * j) == 'F')
					cnt++;
			}
		}
	}
	cout << cnt;
	return 0;
}