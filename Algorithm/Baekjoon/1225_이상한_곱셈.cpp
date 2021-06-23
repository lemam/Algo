#include <iostream>
#include <string>
#include <vector>

using namespace std;

// 한 자리씩 벡터에 저장
vector<int> getNumbers(string str) {
	vector<int> vec;

	int size = str.length();
	for (int i = 0; i < size; i++) {
		vec.push_back(str[i] - '0');
	}

	return vec;
}

int main() {

	string strA, strB;
	cin >> strA >> strB;

	vector<int> A = getNumbers(strA); 
	vector<int> B = getNumbers(strB);
	int lenA = strA.length();
	int lenB = strB.length();
	long result = 0;

	for (int i = 0; i < lenA; i++) {
		for (int j = 0; j < lenB; j++) {
			result += A[i] * B[j];
		}
	}

	cout << result;

	return 0;
}