#include <iostream>
using namespace std;

int d[1001];

int dp(int n) {
	if (n == 1)return 1;
	else if (n == 2)return 3;
	if (d[n] > 0) return d[n]; //이미 값이 계산된 경우 그 값을 반환한다
	else {
		d[n] = (dp(n - 1) + 2 * dp(n - 2)) % 10007;
		return d[n];
	}
}

int main() {
	int num;
	cin >> num;
	cout << dp(num);
}