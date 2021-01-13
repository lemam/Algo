//#include <iostream>
//
//int Count(int x, int y);
//
//int main()
//{
//	int T, x, y;
//
//	std::cin >> T;
//	for (int i = 0; i < T; i++)
//	{
//		std::cin >> x >> y;
//		std::cout << Count(x, y);
//	}
//	return 0;
//}
//
//int Count(int x, int y)
//{
//	int curX = x;
//	int cnt = 0;
//	int k = 0;
//	int td = 0;
//
//	while (curX != y)
//	{
//		int dir = y - curX;
//
//		if (dir - td > k)
//		{
//			k++;
//			td += k;
//		}
//		else if (dir - td < 0)
//			k--;
//		
//		curX += k;
//		cnt++;
//	}
//	return cnt;
//}