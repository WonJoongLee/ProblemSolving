#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

bool compare(string a, string b) {
	if (a.length() == b.length()) return a < b;
	return a.length() < b.length();
}

int main() {
	int t;
	vector<string> vec;
	cin >> t;
	for (int i = 0; i < t; i++) {
		string str;
		cin >> str;
		if (find(vec.begin(), vec.end(), str) == vec.end()) { //cpp���� �����ϴ� find�Լ� �Ű����� : (find(vector �����ϴ� �κ�, vector ������ �κ�, ã������ �ϴ� ��(���⼭�� str))
														      //find�� ã�� ���ϸ� vec�� end�� ���ְ� �ȴ�. �׷��� ���� ���� ã�� ���ϸ� end�� ��ȯ�ϰ� �ȴ�.
			vec.push_back(str);//���� ���� ���� ���� �� str�� �ڿ� �߰����ش�.
		}
	}
	sort(vec.begin(), vec.end(), compare);
	for (int i = 0; i < vec.size(); i++) {
		cout << vec[i] << "\n";
	}
}
