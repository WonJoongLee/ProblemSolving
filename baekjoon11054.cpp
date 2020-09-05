#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int a[1001], d1[1001], d2[1001], ans[1001];
	int n, middle, d1_max, d2_max, max_ans;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}//��������� ���� �Է� �޴� �κ��Դϴ�.

	/*�ְ���, �� ���������� ������ ���� i�� ��� Ǯ�����ϴ�.*/
	for (int i = 1; i <= n; i++) {
		/*���� dp����� �ִ밪�� ���� 1�� 0���� �ʱ�ȭ �����ݴϴ�.*/
		for (int j = 1; j <= n; j++) {
			d1[j] = 1;
			d2[j] = 1;
		}
		d1_max = 0; 
		d2_max = 0;
		
		for (int j = 1; j <= i; j++) {
			for (int k = 1; k <= j; k++) {
				if (a[j] > a[k] && d1[k] + 1 > d1[j]) {
					d1[j] = d1[k] + 1;
				}
			}
		}
		for (int j = 1; j <= i; j++) {
			d1_max = max(d1_max, d1[j]);
		}
		//���⼭ �߰������� ������������ �� ū �� ����

		for (int j = i; j <= n; j++) {
			for (int k = i; k <= j; k++) {
				if (a[j] < a[k] && d2[k] + 1 > d2[j]) {
					d2[j] = d2[k] + 1;
				}
			}
		}
		for (int j = i; j <= n; j++) {
			//cout << d2[j] << " " ;
			d2_max = max(d2_max, d2[j]);
		}
		//cout << endl;
		//���⼭ �߰������� ������ ������������ �� ū �� ����
		cout << "d1_max : " << d1_max << " ///// ";
		cout << "d2_max : " << d2_max << " ///// ";
		cout << "hap : " << d1_max + d2_max-1 << "\n";
		ans[i] = d1_max + d2_max - 1;//i�� 1�϶����� n�϶����� ������ ������ �Է��ϴ� ���Դϴ�.
	}
	
	for (int i = 1; i <= n; i++) {
		max_ans = max(ans[i], max_ans);
	}

	cout << max_ans;
}