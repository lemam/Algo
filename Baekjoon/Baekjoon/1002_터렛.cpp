#include <iostream>
#include <math.h>
using namespace std;

int main()
{
	int T;
	double x1, y1, r1, x2, y2, r2;
	cin >> T;

	for (int t = 0; t < T; t++)
	{
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		double d = sqrt(pow((x2 - x1), 2) + pow((y2 - y1), 2));

		if (r1 == r2 && d == 0)								// 원 겹침
			cout << -1 << "\n";
		else if ((r1 + r2 < d) || (fabs(r1 - r2) > d))		// 만나지 않음
			cout << 0 << "\n";
		else if ((r1 + r2 == d) || (fabs(r1 - r2) == d))	// 외접, 내접
			cout << 1 << "\n";
		else												// 서로 다른 두 점에서 만남
			cout << 2 << "\n";
	}

	return 0;
}