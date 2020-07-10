/* 스택이나 큐로 써서 다시 풀어야 할듯
   테스트 케이스는 중간에 잘 됐으나
   3
   2 3
   1 2
   이 테스트 케이스가 오류가 난다.
   bfs/dfs쪽 다시 공부하고 다시 풀어보기
   200528-00:34 첫 푸쉬
*/

#include <stdio.h>

typedef struct node {
	int key;//노드 번호가 적혀져 있다.
	int chk;//chk가 0이면 forest상황처럼 트리가 다른 곳에 위치해있음
	struct node* left;
	struct node* right;
}Node;

Node* SearchTree(Node* head, int key) {
	if (head != NULL) {
		if (head->key == key)
			return head;
		else {
			Node* temp = SearchTree(head->left, key);
			if (temp != NULL)
				return temp;
			return SearchTree(head->right, key);
		}
	}
	return NULL;
}

Node* SearchChildTree(Node* head, int key) {
	if (head != NULL) {
		if ((head->left != NULL) && (head->left->key == key))//노드의 left가 NULL이 아니고 key가 찾으려는 key값과 같을 때
			return head;
		else if ((head->right != NULL) && (head->right->key == key))
			return head;
		else {//만약 head의 자녀가 아니라면, 아래 실행.
			Node* temp = SearchChildTree(head->left, key);//먼저 left 탐색
			if (temp != NULL)//왼쪽의 끝까지 갔다면 NULL이므로 이 부분 무시하고 넘어감
							 //왼쪽의 끝이 아니여서 temp가 NULL이 아니라면 temp를 반환함. 여기서 함수가 끝남
				return temp;
			return SearchChildTree(head->right, key);//오른쪽 탐색
		}
	}
	return NULL;
}

int chk(Node* node) {
	if (node->left->right == node) {
		return 2;//서로 같은 레벨, 즉 공중에 띄워져있은 두 노드임.
	}
	else if (node->right->left == node) {
		return 1;
	}
	else
		return 0;//둘 다 아닐 경우 0 반환
}


int main() {
	int t, i, a, b;//a와 b는 두 정점
	Node* head = (Node*)malloc(sizeof(Node));
	head->left = NULL;
	head->right = NULL;
	head->key = 1;//루트를 1로 초기화 한다.
	scanf("%d", &t);

	for (i = 0; i < t - 1; i++) {
		Node* pos = (Node*)malloc(sizeof(Node));//탐색한 노드의 위치를 저장할 임시 변수
		Node* newNode = (Node*)malloc(sizeof(Node));//새로 추가할 노드다.
		Node* newNode2 = (Node*)malloc(sizeof(Node));//새로 추가할 노드다.
		newNode->left = NULL;
		newNode->right = NULL;

		scanf("%d %d", &a, &b);

		pos = SearchTree(head, a);//기존 트리에서 a가 있는지 탐색한다.

		if (pos != NULL) {
			if (pos->left == NULL) {//만약 왼쪽 노드가 비었으면 왼쪽 노드에 삽입
				if (chk(pos) == 1) {//만약 공중에 띄워져있는 노드들이라면
					pos->left = newNode;
					pos->left->right = NULL;
				}
				else if (chk(pos) == 2) {
					pos->left = newNode;
					pos->right->left = NULL;
				}
				else {
					pos->left = newNode;
					newNode->key = b;
					newNode->right = NULL;
					newNode->left = NULL;
				}
			}
			else if (pos->right == NULL) {//오른쪽 노드가 비었으면 오른쪽 노드에 삽입
				if (chk(pos) == 1) {//만약 공중에 띄워져있는 노드들이라면
					pos->right = newNode;
					pos->left->right = NULL;
				}
				else if (chk(pos) == 2) {
					pos->right = newNode;
					pos->right->left = NULL;
				}
				else {
					pos->right = newNode;
					newNode->key = b;
					newNode->right = NULL;
					newNode->left = NULL;
				}
			}
		}
		else if (pos == NULL) {
			pos = SearchTree(head, b);//기존 트리에서 a를 못찾았으므로 b가 있는지 탐색한다.
			if (pos != NULL) {//기존 트리에서 b를 찾았으면 아래 조건문 실행
				if (pos->left == NULL) {
					pos->left = newNode;
					newNode->key = a;
					newNode->right = NULL;
					newNode->left = NULL;
				}
				else if (pos->right == NULL) {
					pos->right = newNode;
					newNode->key = a;
					newNode->right = NULL;
					newNode->left = NULL;
				}
			}
			else if (pos == NULL) {//a와 b를 둘 다 찾지 못했으면 아래 조건문 실행
				newNode->key = a;
				newNode->left = NULL;
				newNode->right = NULL;
				newNode->right = newNode2;
				newNode2->key = b;
				newNode2->left = NULL;
				newNode2->right = NULL;
				newNode2->left = newNode;
			}
		}
	}

	for (i = 2; i <= t; i++) {
		Node* pos = (Node*)malloc(sizeof(Node));//탐색한 노드의 위치를 저장할 임시 변수
		pos = SearchChildTree(head, i);
		printf("%d\n", pos->key);
	}
	return 0;
}

