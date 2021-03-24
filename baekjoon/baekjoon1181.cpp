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
		if (find(vec.begin(), vec.end(), str) == vec.end()) { //cpp에서 제공하는 find함수 매개변수 : (find(vector 시작하는 부분, vector 끝나는 부분, 찾으려고 하는 값(여기서는 str))
														      //find가 찾지 못하면 vec가 end로 가있게 된다. 그래서 같은 것을 찾지 못하면 end를 반환하게 된다.
			vec.push_back(str);//만약 같은 것이 없을 때 str을 뒤에 추가해준다.
		}
	}
	sort(vec.begin(), vec.end(), compare);
	for (int i = 0; i < vec.size(); i++) {
		cout << vec[i] << "\n";
	}
}
