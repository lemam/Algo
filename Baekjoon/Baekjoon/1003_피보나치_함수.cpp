#include <iostream>
using namespace std;

int f[41] = { 0, };

int fibonacci(int n) 
{
    int result;

    if (n < 2)
        result = n;
    else
    {
        if (f[n])
            result = f[n];
        else
            result = f[n] = fibonacci(n - 1) + fibonacci(n - 2);
    }

    return result;
}

int main()
{
    int T;
    cin >> T;

    while (T--)
    {
        int n;
        cin >> n;
        if (n > 0)
            cout << fibonacci(n - 1) << " " << fibonacci(n) << "\n";
        else
            cout << fibonacci(1) << " " << fibonacci(0) << "\n";
    }
    return 0;
}