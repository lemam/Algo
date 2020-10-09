#include <iostream>
#include <vector>

using namespace std;
int main()
{
	vector<char> v;
	char str[101];
	cin >> str;

	for (int i = 0; i < 101; i++)
	{
		if (str[i] == NULL)
			break;

		if (str[i] == 'c' || str[i] == 'd' || str[i] == 'l' 
			|| str[i] == 'n' || str[i] == 's' || str[i] == 'z')
		{
			if (str[i + 1] != NULL)
			{
				if (str[i] == 'c')	// c=, c-
				{
					if (str[i + 1] == '=' || str[i + 1] == '-')
					{
						v.push_back('*');
						i += 1;
						continue;
					}
				}

				else if (str[i] == 'd') {	// d-
					if (str[i + 1] == '-')
					{
						v.push_back('*');
						i += 1;
						continue;
					}
					else if (str[i + 1] == 'z')	// dz=
					{
						if (str[i + 2] != NULL)
						{
							if (str[i + 2] == '=')
							{
								v.push_back('*');
								i += 2;
								continue;
							}
						}
					}
				}

				else if (str[i] == 'l')	// lj
				{
					if (str[i + 1] == 'j')
					{
						v.push_back('*');
						i += 1;
						continue;
					}
				}

				else if (str[i] == 'n')	// nj
				{
					if (str[i + 1] == 'j')
					{
						v.push_back('*');
						i += 1;
						continue;
					}
				}

				else if (str[i] == 's')	// s=
				{
					if (str[i + 1] == '=')
					{
						v.push_back('*');
						i += 1;
						continue;
					}
				}

				else if (str[i] == 'z')	// z=
				{
					if (str[i + 1] == '=')
					{
						v.push_back('*');
						i += 1;
						continue;
					}
				}
				v.push_back(str[i]);
			}
			else
				v.push_back(str[i]);
		}
		else
			v.push_back(str[i]);
	}
	cout << v.size();

	return 0;
}