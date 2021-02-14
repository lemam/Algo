#include <iostream>
using namespace std;

int main()
{
	int list[3][2];

	for (int i = 0; i < 3; i++)
	{
		cin >> list[i][0] >> list[i][1];
	}

	int x = list[0][0] == list[1][0] ? list[2][0] : (list[0][0] == list[2][0] ? list[1][0] : list[0][0]);
	int y = list[0][1] == list[1][1] ? list[2][1] : (list[0][1] == list[2][1] ? list[1][1] : list[0][1]);
	
	cout << x << " " << y;

	return 0;
}