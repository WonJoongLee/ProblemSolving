#include <iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	int arr[301];
	int d[301];
	
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	d[1] = arr[1];
	d[2] = arr[1] + arr[2];
	for (int i = 3; i <= n; i++) {
		d[i] = max(d[i - 2] + arr[i], d[i - 3] + arr[i - 1] + arr[i]);
	}
	cout << d[n];
}