#include <iostream>
#include <string>
#include <stdlib.h>
using namespace std;

int main() {
	string num1, num2, zero, ans, up;
	int chk = 0;
	up = zero = "0";
	ans = "";
	cin >> num1 >> num2;
	//int* sum = new int(num1.length());
	//int* up = new int(num1.length());
	
	int len1, len2;
	//cout << num1[num1.length() - 1];//�� �ߵǴ��� �غ���
	len1 = num1.length();
	len2 = num2.length();

	/*�ڸ��� �����ִ� ���ǹ�*/
	if (len1 > len2) {
		for (int i = 0; i < len1 - len2 - 1; i++) {//�̹� zero�� 0�� �ϳ� ���� �Ǿ� �־ len1-len2-1�� ����� �Ѵ�
			zero.append("0");
		}
		zero.append(num2);
		num2 = zero;
		len2 = len1; // ���̸� �÷������� ���� �����ش�
	}
	else if (len1 < len2) {
		for (int i = 0; i < len2 - len1 - 1; i++) {
			zero.append("0");
		}
		zero.append(num1);
		num1 = zero;
		len1 = len2;// ���̸� �÷������� ���� �����ش�
	}

	for (int i = 0; i < len1; i++) {
		ans.append("0");
		up.append("0");
	}
	
	int t = len1 - 1;
	while (t >= 0) {
		/*string�� t�κ� �迭�� ���ڷ� �ٲ۵�*/
		char temp;
		temp = num1[t];
		int n1 = temp - '0';
		temp = num2[t];
		int n2 = temp - '0';
		temp = up[t];
		int u = temp - '0';

		if (n1 + n2 + u >= 10) {
			if(t-1<0){
				chk = 1;
			}
			else {
				up.replace(t - 1, 1, "1");
			}

			int calc = n1 + n2 + u - 10;
			ans.replace(t, 1, to_string(calc));//calc�� string���� �ٲ� �� t��ġ�� ����
		}
		else {
			int calc = n1 + n2 + u;
			ans.replace(t, 1, to_string(calc));
		}
		t--;
	}
	zero = "1";
	if (chk == 1) {
		zero.append(ans);
		ans = zero;
	}
	cout << ans;
}
