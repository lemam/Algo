#include <iostream>
using namespace std;

int main() {
	int N, temp, cnt = 0;
	cin >> N;
	temp = N;

	while (++cnt) {
		int a = temp / 10;	// 십의 자리 수
		int b = temp % 10;	// 일의 자리 수
		temp = (b * 10) + ((a + b) % 10);	// 새로운 수

		if (N == temp) {
			cout << cnt;
			break;
		}
	}
	return 0;
}