#include <iostream>

int main() {
	int X;
	int col, row, cnt;
	bool flag;

	col = row = cnt = 1;
	std::cin >> X;

	while (cnt != X)
	{
		if ((row == 1) && (col % 2 != 0))	// 오른쪽으로 이동
		{
			col++;
			flag = true;
		}
		else if ((row % 2 == 0) && (col == 1))	// 아래쪽으로 이동
		{
			row++;
			flag = false;
		}
		else
		{
			if (flag)	// 대각선 아래로
			{
				row++;
				col--;
			}
			else    // 대각선 위로
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