#include <iostream>
using namespace std;
int main() {
	int count;
	cin >> count;
	int* d = new int[count+1];
	d[1] = 0;
	for (int i = 2; i <= count; i++) {
		d[i] = d[i - 1] + 1;
		if (i % 2 == 0 && d[i] > d[i / 2] + 1) {
			d[i] = d[i / 2] + 1;
		}
		if (i % 3 == 0 && d[i] > d[i / 3] + 1) {
			d[i] = d[i / 3] + 1;
		}
	}
	cout << d[count];
}