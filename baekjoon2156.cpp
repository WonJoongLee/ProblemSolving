#include <iostream>
using namespace std;

int main() {
	int d[10001][2] = { 0 };
	int num;
	cin >> num;
	int* arr = new int[num + 1];
	for (int i = 1; i <= num; i++) {
		cin >> arr[i];
	}
	d[1][0] = 0;
	d[1][1] = arr[1];

	for (int i = 1; i <= num; i++) {
		d[i][0] = max(max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
		d[i][1] = d[i - 1][0] + arr[i];//bottom-up�����̴��� �̷��� n-1�� ����� ��, ó���� ���� ���� ���� n+1�� �߰�, bottomup�̿��� ������ �ڿ� �ִ� ������ ���� ������.
		//bottomup�̿��� i+1�� �ƴ� i-1�������� ���� ��
		d[i][2] = d[i - 1][1] + arr[i];
	}

	cout << max(max(d[num][0], d[num][1]), d[num][2]);
}