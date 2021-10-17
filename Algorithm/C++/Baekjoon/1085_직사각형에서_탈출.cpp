#include <iostream>
using namespace std;

int main()
{
	int x, y, w, h;
	int minX = 0, minY = 0;

	cin >> x >> y >> w >> h;
	
	minX = x >= w - x ? w - x : x;
	minY = y >= h - y ? h - y : y;

	minX >= minY ? cout << minY : cout << minX;

	return 0;
}