#include <iostream>

int main() {
	int X;
	int col, row, cnt;
	bool flag;

	col = row = cnt = 1;
	std::cin >> X;

	while (cnt != X)
	{
		if ((row == 1) && (col % 2 != 0))	// ���������� �̵�
		{
			col++;
			flag = true;
		}
		else if ((row % 2 == 0) && (col == 1))	// �Ʒ������� �̵�
		{
			row++;
			flag = false;
		}
		else
		{
			if (flag)	// �밢�� �Ʒ���
			{
				row++;
				col--;
			}
			else    // �밢�� ����
			{
				row--;
				col++;
			}
		}
		cnt++;
	}
	std::cout << row << "/" << col;

	return 0;
}