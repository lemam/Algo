#include <iostream>
using namespace std;

int main() {
	int N, m, M, T, R, X, n = 0;
	cin >> N >> m >> M >> T >> R;
	X = m;

	while (N)
	{
		if (m + T > M) {
			n = -1;
			break;
		}

		// ¿îµ¿
		if (X <= M - T) {
			X += T;
			N--;
		}
		// ÈÞ½Ä
		else {
			X = (X - R < m) ? m : X - R;
		}
		n++;
	}
	cout << n;
	return 0;
}