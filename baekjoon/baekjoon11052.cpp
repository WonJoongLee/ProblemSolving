#include <iostream>
#include <algorithm>
using namespace std;

int d[1001] = { 0 };

int main() {
	int kind;
	cin >> kind;
	int* price = new int[kind + 1];
	for (int i = 1; i <= kind; i++) {//주어진 값 입력받는 부분
		cin >> price[i];
	}
	for (int i = 1; i <= kind; i++) {//종류가 kind만큼 있으니까 kind까지 반복
		for (int j = 1; j <= i; j++) {
			if (d[i] < d[i - j] + price[j])//제일 큰 값 저장하는 부분
				d[i] = d[i - j] + price[j];
		}
	}
	cout << d[kind];
}