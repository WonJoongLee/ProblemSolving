#include <iostream>
using namespace std;

int main() {
	int n, big;
	cin >> n;
	int *arr = new int[n];
	int* d = new int[n];
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	big = arr[0];
	d[0] = arr[0];
	for (int i = 1; i < n; i++) {
		d[i] = max(d[i-1] + arr[i], arr[i]);
	}

	for (int i = 0; i < n; i++) {
		if (d[i] > big) {
			big = d[i];
		}
	}

	cout << big;
}