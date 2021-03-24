#include <iostream>
#include <string.h>
using namespace std;

int main() {
	int t;
	int floor, roomNumber;
	cin >> t;
	while (t--) {
		cin >> floor; cin >> roomNumber;
		int** arr = new int* [floor+1];
		for (int i = 0; i < floor+1; i++) {
			arr[i] = new int[roomNumber];
			memset(arr[i], 0, sizeof(int*) * roomNumber);
		}

		
		for (int i = 0; i < roomNumber; i++) {
			arr[0][i] = i+1;/*1�� �ʱ�ȭ*/
		}

		for (int i = 1; i < floor + 1; i++) {
			arr[i][0] = 1; // �� �� 1ȣ 1�� �ʱ�ȭ
			for (int j = 1; j < roomNumber; j++) {
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];		
			}
		}

		//for (int i = 0; i < floor + 1; i++) {
//			for (int j = 0; j < roomNumber; j++) {
				//cout << arr[i][j] << "     ";
			//}
			//cout << "\n";
		//}

		cout << arr[floor][roomNumber-1] << "\n";

		for (int i = 0; i < floor; i++) {
			delete[] arr[i];
		}
		delete arr;
	}
}