#include <iostream>
#include <algorithm>
using namespace std;

int d[1001] = { 0 };

int main() {
	int kind;
	cin >> kind;
	int* price = new int[kind + 1];
	for (int i = 1; i <= kind; i++) {//�־��� �� �Է¹޴� �κ�
		cin >> price[i];
	}
	for (int i = 1; i <= kind; i++) {//������ kind��ŭ �����ϱ� kind���� �ݺ�
		for (int j = 1; j <= i; j++) {
			if (d[i] < d[i - j] + price[j])//���� ū �� �����ϴ� �κ�
				d[i] = d[i - j] + price[j];
		}
	}
	cout << d[kind];
}