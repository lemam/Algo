#include <iostream>
#include <map>
using namespace std;

int main() {
	int N;
	string result;
	map<char, int> map;
	std::map<char, int>::iterator it;

	// insert map
	cin >> N;
	while (N--)
	{
		string name;
		cin >> name;
		char i = name[0];
		map[i]++;
	}

	// find
	for (it = map.begin(); it != map.end(); it++) {
		if (it->second >= 5)
			result += it->first;
	}
	result = result.length() == 0 ? "PREDAJA" : result;
	cout << result;

	return 0;
}