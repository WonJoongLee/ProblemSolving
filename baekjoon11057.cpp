#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	int d[1001][10] = { 0 };
	for (int i = 0; i <= 9; i++) {
		d[1][i] = 1; // �ڸ����� �� �ڸ��� ������ �� 1�� �ʱ�ȭ
	}

	for(int i=2;i<=n;i++){
		for (int j = 0; j <= 9; j++) {//0������ �������ϹǷ� ���ڸ� ���� �� �ڸ� n���� Ŀ���� �ȵǹǷ� n������ �Ѵ�
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