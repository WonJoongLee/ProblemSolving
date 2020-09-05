#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	int a[1001], d1[1001], d2[1001], ans[1001];
	int n, middle, d1_max, d2_max, max_ans;
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> a[i];
	}//여기까지가 값을 입력 받는 부분입니다.

	/*최고점, 즉 오름차순의 마지막 수를 i로 잡고 풀었습니다.*/
	for (int i = 1; i <= n; i++) {
		/*먼저 dp값들과 최대값을 각각 1과 0으로 초기화 시켜줍니다.*/
		for (int j = 1; j <= n; j++) {
			d1[j] = 1;
			d2[j] = 1;
		}
		d1_max = 0; 
		d2_max = 0;
		
		for (int j = 1; j <= i; j++) {
			for (int k = 1; k <= j; k++) {
				if (a[j] > a[k] && d1[k] + 1 > d1[j]) {
					d1[j] = d1[k] + 1;
				}
			}
		}
		for (int j = 1; j <= i; j++) {
			d1_max = max(d1_max, d1[j]);
		}
		//여기서 중간점까지 오름차순으로 젤 큰 값 구함

		for (int j = i; j <= n; j++) {
			for (int k = i; k <= j; k++) {
				if (a[j] < a[k] && d2[k] + 1 > d2[j]) {
					d2[j] = d2[k] + 1;
				}
			}
		}
		for (int j = i; j <= n; j++) {
			//cout << d2[j] << " " ;
			d2_max = max(d2_max, d2[j]);
		}
		//cout << endl;
		//여기서 중간점부터 끝까지 내림차순으로 젤 큰 값 구함
		cout << "d1_max : " << d1_max << " ///// ";
		cout << "d2_max : " << d2_max << " ///// ";
		cout << "hap : " << d1_max + d2_max-1 << "\n";
		ans[i] = d1_max + d2_max - 1;//i가 1일때부터 n일때까지 저장한 값들을 입력하는 곳입니다.
	}
	
	for (int i = 1; i <= n; i++) {
		max_ans = max(ans[i], max_ans);
	}

	cout << max_ans;
}