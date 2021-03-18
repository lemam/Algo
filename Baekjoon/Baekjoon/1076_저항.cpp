#include <iostream>
#include <map>
#include <math.h>
using namespace std;

int main() {
	string c1, c2, c3;
	map<string, int> map = 
	{
		{"brown", 1}, {"red", 2}, {"orange", 3}, {"yellow", 4}, {"green", 5},
		{"blue", 6}, {"violet", 7}, {"grey", 8}, {"white", 9}
	};

	cin >> c1 >> c2 >> c3;
	cout << (map[c1] * 10 + map[c2]) * (long long)pow(10, map[c3]);
	return 0;
}