#include <iostream>
using namespace std;

int main() {
	int a[1001];
	int d[1001];
	int n, biggest = 0;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		d[i] = 1;
		cin >> a[i];
	}
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			if (a[i] < a[j] && d[i] < d[j] + 1) {
				d[i] = d[j] + 1;
			}
		}
	}
	for (int i = 1; i <= n; i++) {
		biggest = max(biggest, d[i]);
	}
	cout << biggest;
}