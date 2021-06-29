#include <iostream>
#include <math.h>

using namespace std;

class Planet {
public:
	int cx = 0;
	int cy = 0;
	int r = 0;

	bool checkInnerPoint(int x1, int y1, int x2, int y2) {
		int dir1 = sqrt(pow(cx - x1, 2) + pow(cy - y1, 2));
		int dir2 = sqrt(pow(cx - x2, 2) + pow(cy - y2, 2));

		if (dir1 < r && dir2 < r) return false;
		else if (dir1 < r || dir2 < r) return true;

		return false;
	}
};


int main() {
	int T;

	cin >> T;

	while (T--)
	{
		int x1, y1, x2, y2, n, result = 0;
		Planet planets[50];

		cin >> x1 >> y1 >> x2 >> y2 >> n;

		for (int i = 0; i < n; i++) {
			cin >> planets[i].cx >> planets[i].cy >> planets[i].r;
		}

		for (int i = 0; i < n; i++) {
			if (planets[i].checkInnerPoint(x1, y1, x2, y2))
				result++;
		}

		cout << result << "\n";
	}

	return 0;
}