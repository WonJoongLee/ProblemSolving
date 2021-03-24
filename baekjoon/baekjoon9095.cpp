#include <iostream>
using namespace std;

int d[11];

int dp(int n) {
	if (n == 1)return 1;
	else if (n == 2)return 2;
	else if (n == 3)return 4;
	if (d[n] > 0)return d[n];
	else {
		d[n] = dp(n - 1) + dp(n - 2) + dp(n - 3);
		return d[n];
	}
}

int main() {
	int num, t;
	cin >> t;
	while(t--){
		cin >> num;
		cout << dp(num) << endl;
	}
}