#include <vector>
long long sum(std::vector<int>& a) {
	long long ans = 0;

	for (int n : a)
		ans += n;

	return ans;
}