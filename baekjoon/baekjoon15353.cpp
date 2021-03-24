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
	//cout << num1[num1.length() - 1];//걍 잘되는지 해본거
	len1 = num1.length();
	len2 = num2.length();

	/*자릿수 맞춰주는 조건문*/
	if (len1 > len2) {
		for (int i = 0; i < len1 - len2 - 1; i++) {//이미 zero에 0이 하나 선언 되어 있어서 len1-len2-1을 해줘야 한다
			zero.append("0");
		}
		zero.append(num2);
		num2 = zero;
		len2 = len1; // 길이를 늘려줬으니 같게 맞춰준다
	}
	else if (len1 < len2) {
		for (int i = 0; i < len2 - len1 - 1; i++) {
			zero.append("0");
		}
		zero.append(num1);
		num1 = zero;
		len1 = len2;// 길이를 늘려줬으니 같게 맞춰준다
	}

	for (int i = 0; i < len1; i++) {
		ans.append("0");
		up.append("0");
	}
	
	int t = len1 - 1;
	while (t >= 0) {
		/*string의 t부분 배열을 숫자로 바꾼디*/
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
			ans.replace(t, 1, to_string(calc));//calc를 string으로 바꾼 후 t위치에 저장
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
