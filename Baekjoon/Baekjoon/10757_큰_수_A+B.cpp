#include <iostream>
#include <string>
using namespace std;

int main()
{
	string A, B, result;
	int carry = 0;	// �ø�
	int remain = 0;	// ���� 

	cin >> A >> B;

	// ���ڸ��� 0 �־��ֱ�
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
	
	// �ڸ����� ���� ���ϱ�
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