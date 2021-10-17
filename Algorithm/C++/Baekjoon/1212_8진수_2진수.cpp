#include <iostream>

using namespace std;

class Binary {
	string fisrtBinary[8] = { "0", "1", "10", "11", "100","101", "110", "111" };
	string extraBinary[8] = { "000", "001", "010", "011", "100", "101", "110", "111" };

	string input;
	string result;

public:
	Binary() {
		cin >> input;
	}

	void convertNumber();
	string getFirstNum(int idx);
	string getExtraNum(int idx);
	void print();
};

void Binary::convertNumber() {
	// 각 자리 수의 2진수 세자리 구하기
	// 값이 0으로 시작하지 않도록 한다.

	int length = static_cast<int>(input.length());

	result += getFirstNum(input[0] - '0');

	for (int i = 1; i < length; i++) {
		result += getExtraNum(input[i] - '0');
	}
}

string Binary::getFirstNum(int idx) {
	return fisrtBinary[idx];
}

string Binary::getExtraNum(int idx) {
	return extraBinary[idx];
}

void Binary::print() {
	cout << result;
}


int main() {
	Binary oct;
	oct.convertNumber();
	oct.print();

	return 0;
}