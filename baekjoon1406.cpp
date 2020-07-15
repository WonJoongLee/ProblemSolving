#include <iostream>
#include <string>
#include <stack>
#include <list>
using namespace std;
int main() {
	string given, order;
	int t;
	stack<char> stk1, stk2;
	char temp;

	cin >> given;
	cin >> t;

	for (int i = 0; i < given.size(); i++) {
		stk1.push(given[i]);
	}
	cin.ignore(256, '\n');
	while (t--) {
		//cin >> order;.
		
		getline(cin, order);
		if (order.size() == 3) {
			stk1.push(order[2]);
		}
		else if (order[0] == 'L') {
			if (stk1.size() > 0) {
				stk2.push(stk1.top());
				stk1.pop();
			}
		}
		else if (order[0] == 'D') {
			if(stk2.size()>0){
				stk1.push(stk2.top());
				stk2.pop();
			}
		}
		else if (order[0] == 'B') {
			if (stk1.size() > 0) {
				stk1.pop();
			}
		}
	}

	//cout << stk2.size();

	while (!stk1.empty()) {
		stk2.push(stk1.top());
		stk1.pop(); 
	}

	while (!stk2.empty()) {
		cout << stk2.top();
		stk2.pop();
	}

	//for (int i = 0; i < stk1.size(); i++) {
	//	stk2.push(stk1.top());
	//	stk1.pop();
	//}

	//cout << stk2.size();

	//for (int i = stk2.size(); i > 0; i--) {
	//	cout << stk2.top();
	//	stk2.pop();
	//}

}