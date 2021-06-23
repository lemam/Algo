#include <iostream>

using namespace std;

long long A, B;
string strA, strB;

int main() {

	cin >> strA >> strB;

	for (char c : strA) A += c - '0';
	for (char c : strB) B += c - '0';
	cout << A * B;

	return 0;
}