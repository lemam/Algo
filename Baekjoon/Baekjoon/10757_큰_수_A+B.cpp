#include <iostream>
#include <string>
using namespace std;

int main()
{
	string A, B, result;
	int carry = 0;	// 올림
	int remain = 0;	// 남음 

	cin >> A >> B;

	// 빈자리에 0 넣어주기
	if (A.size() > B.size())
	{
		int cnt = A.size() - B.size();
		for (int i = 0; i < cnt; i++)
		{
			B = '0' + B;
		}
	}
	else
	{
		int cnt = B.size() - A.size();
		for (int i = 0; i < cnt; i++)
		{
			A = '0' + A;
		}
	}
	
	// 자릿수에 맞춰 더하기
	int size = A.size();
	for (int i = size - 1; i >= 0; i--)
	{
		int a = A.at(i) - '0';
		int b = B.at(i) - '0';
		int r = a + b + carry;

		remain = r % 10;
		carry = r / 10;

		result = (char)(remain + '0') + result;
	}
	if (carry != 0)
		result = (char)(carry + '0') + result;

	cout << result;
	return 0;
}