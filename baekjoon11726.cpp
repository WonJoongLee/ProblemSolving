#include <iostream>
using namespace std;

int D[1001];

int dp(int n) {
	if (n <= 1) return 1;
	else if (n == 2)return 2;
	if (D[n] != 0) {//�̹� ���� ��
		return D[n];
	}
	else {//��� �ȵ� �� 
		D[n] = (dp(n - 1) + dp(n - 2)) % 10007;
		return D[n];
	}
}

int main() {
	int input;
	int d;
	cin >> input;
	cout << dp(input);
}