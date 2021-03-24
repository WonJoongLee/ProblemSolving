#include <iostream>
using namespace std;

int go(int count, int* d) {
	if (count == 1)return 0;
	if (d[count] > 0)return d[count];
	d[count] = go(count - 1, d) + 1;
	if (count % 2 == 0) {
		int temp = go(count / 2, d) + 1;
		if (d[count] > temp) d[count] = temp;
	}
	if (count % 3 == 0) {
		int temp = go(count / 3, d) + 1;
		if (d[count] > temp) d[count] = temp;
	}
	return d[count];
}

int main() {
	int count;
	cin >> count;
	int* d = new int[count + 1];
	for (int i = 0; i <= count; i++) {
		d[i] = 0;
	}
	cout << go(count, d);
}