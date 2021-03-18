#include <iostream>
#include <string>
using namespace std;

int main() {
	string color, result;
	int idx, mul;

	for (int i = 0; i < 3; i++)
	{
		cin >> color;
		if (color == "black")
		{
			idx = 0;
			mul = 1;
		}
		else if (color == "brown")
		{
			idx = 1;
			mul = 10;
		}
		else if (color == "red")
		{
			idx = 2;
			mul = 100;
		}
		else if (color == "orange")
		{
			idx = 3;
			mul = 1000;
		}
		else if (color == "yellow")
		{
			idx = 4;
			mul = 10000;
		}
		else if (color == "green")
		{
			idx = 5;
			mul = 100000;
		}
		else if (color == "blue")
		{
			idx = 6;
			mul = 1000000;
		}
		else if (color == "violet")
		{
			idx = 7;
			mul = 10000000;
		}
		else if (color == "grey")
		{
			idx = 8;
			mul = 100000000;
		}
		else if (color == "white")
		{
			idx = 9;
			mul = 1000000000;
		}

		if (i < 2)
		{
			if (i == 0 && idx == 0)
				continue;

			result += to_string(idx);
		}
		else
			cout << stoll(result) * mul << "\n";
	}
	return 0;
}