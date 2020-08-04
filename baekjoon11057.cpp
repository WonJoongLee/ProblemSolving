#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	int d[1001][10] = { 0 };
	for (int i = 0; i <= 9; i++) {
		d[1][i] = 1; // 자릿수가 한 자리인 오르막 수 1로 초기화
	}

	for(int i=2;i<=n;i++){
		for (int j = 0; j <= 9; j++) {//0오르막 수여야하므로 앞자리 수가 뒷 자리 n보다 커지면 안되므로 n까지로 한다
			for (int k = 0; k <= j; k++) {
				d[i][j] += d[i - 1][k];
				d[i][j] %= 10007;
			}
		}
	}

	long long ans = 0;
	for (int i = 0; i <= 9; i++) {
		ans += d[n][i];
	}

	cout << ans % 10007;
}