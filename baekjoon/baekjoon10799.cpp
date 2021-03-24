#include <iostream>
#include <string>
#include <stack>
using namespace std;
int main() {
	string a;
	char p;
	cin >> a;

	stack<int> s;
	int cnt = 0;

	for (int i = 0; i < a.size(); i++) {
		if (a[i] == '(') {
			s.push(a[i]);
		}
		else {
			if ((i != 0) && (a[i-1]=='(')) {
				s.pop();
				cnt += s.size();
			}
			else if (s.top() == '(') {
				s.pop();
				cnt += 1;
			}
		}
	}

	cout << cnt;

	return 0;
}