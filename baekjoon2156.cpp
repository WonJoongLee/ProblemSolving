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
		d[i][1] = d[i - 1][0] + arr[i];//bottom-up형식이더라도 이렇게 n-1로 해줘야 함, 처음에 내가 했을 때는 n+1로 했고, bottomup이였기 때문에 뒤에 있는 값들을 알지 못했음.
		//bottomup이여도 i+1이 아닌 i-1형식으로 해줄 것
		d[i][2] = d[i - 1][1] + arr[i];
	}

	cout << max(max(d[num][0], d[num][1]), d[num][2]);
}