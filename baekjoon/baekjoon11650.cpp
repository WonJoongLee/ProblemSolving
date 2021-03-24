#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <utility>
using namespace std;

/*sort나 find에 들어가는 compare함수는 아래의 조건이 참, 즉 9번줄에서는 a<b가 참일 때 실행을 하고, 10번 줄에서는 a.length()<b.length()가 참일 때 실행한다*/
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
		//if (find(vec.begin(), vec.end(), str) == vec.end()) { //cpp에서 제공하는 find함수 매개변수 : (find(vector 시작하는 부분, vector 끝나는 부분, 찾으려고 하는 값(여기서는 str))
														      //find가 찾지 못하면 vec가 end로 가있게 된다. 그래서 같은 것을 찾지 못하면 end를 반환하게 된다.
			//vec.push_back(str);//만약 같은 것이 없을 때 str을 뒤에 추가해준다.
		//}
	}
	sort(vec.begin(), vec.end(), compare);
	for (auto coor: vec) {
		cout << coor.first << " " << coor.second << "\n";
	}
}
