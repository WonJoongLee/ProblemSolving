#include <iostream>
#include <cstring>
using namespace std;

int main() {
	int t, col;//test case, column
	cin >> t;
	while (t--) {
		cin >> col;
		long long int** arr = new long long int* [2];//�� ���̴ϱ� 2��ŭ �Է¹ޱ�
		long long int** d = new long long int* [col];//d[�� ��][���� ����]�̹Ƿ� �̷��� ����
		for (int i = 0; i < col; i++) {
			d[i] = new long long int[3];
			memset(d[i], 0, sizeof(long long int) * 3); // �޸� ������ 0���� �ʱ�ȭ
		}
		for (int i = 0; i < 2; i++) {
			arr[i] = new long long int[col];
			memset(arr[i], 0, sizeof(long long int) * col); // �޸� ������ 0���� �ʱ�ȭ
		}
		//2���� �迭 �����Ҵ� ��
		for(int i = 0 ; i < 2 ; i++){
			for (int j = 0; j < col; j++) {
				cin >> arr[i][j];
			}
		}
		/*��������� ���� �Է� �޴� �κ�*/

		d[0][0] = 0;
		d[0][1] = arr[0][0];
		d[0][2] = arr[1][0];

		for (int i = 1; i < col; i++) {
			d[i][0] = max(max(d[i - 1][0], d[i - 1][1]), d[i - 1][2]);
			d[i][1] = max(d[i - 1][0], d[i - 1][2]) + arr[0][i];
			d[i][2] = max(d[i - 1][0], d[i - 1][1]) + arr[1][i];
		}
		
		cout << max(max(d[col - 1][0], d[col - 1][1]), d[col - 1][2])<<"\n";
	}
}