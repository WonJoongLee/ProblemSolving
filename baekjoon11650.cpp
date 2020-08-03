#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

/*sort�� find�� ���� compare�Լ��� �Ʒ��� ������ ��, �� 9���ٿ����� a<b�� ���� �� ������ �ϰ�, 10�� �ٿ����� a.length()<b.length()�� ���� �� �����Ѵ�*/
bool compare(pair <int,int> p1, pair <int, int> p2) {
	if (p1.first == p2.first) return p1.second < p2.second;
	return p1.first < p2.first;
}

int main() {
	int t;
	vector<pair<int, int>> vec;
	cin >> t;
	while(t--) {
		int a, b;
		cin >> a >> b;
		vec.push_back(make_pair(a, b));
		//if (find(vec.begin(), vec.end(), str) == vec.end()) { //cpp���� �����ϴ� find�Լ� �Ű����� : (find(vector �����ϴ� �κ�, vector ������ �κ�, ã������ �ϴ� ��(���⼭�� str))
														      //find�� ã�� ���ϸ� vec�� end�� ���ְ� �ȴ�. �׷��� ���� ���� ã�� ���ϸ� end�� ��ȯ�ϰ� �ȴ�.
			//vec.push_back(str);//���� ���� ���� ���� �� str�� �ڿ� �߰����ش�.
		//}
	}
	sort(vec.begin(), vec.end(), compare);
	for (auto coor: vec) {
		cout << coor.first << " " << coor.second << "\n";
	}
}
