#include <iostream>
using namespace std;

int main() {
	int N, temp, cnt = 0;
	cin >> N;
	temp = N;

	while (++cnt) {
		int a = temp / 10;	// ���� �ڸ� ��
		int b = temp % 10;	// ���� �ڸ� ��
		temp = (b * 10) + ((a + b) % 10);	// ���ο� ��

		if (N == temp) {
			cout << cnt;
			break;
		}
	}
	return 0;
}