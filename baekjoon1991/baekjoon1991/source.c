#include <stdio.h>
#include <stdlib.h>

typedef struct node {
	int key;//알파벳을 저장한다.
	struct node* left;
	struct node* right;
} Node;

void insert(Node* head, int key, char left, char right);
void inorder(Node* ptr);
Node* SearchTree(Node* node, char parent);
void preorder(Node* ptr);
void postorder(Node* ptr);


int main() {
	int n, i;

	scanf("%d", &n);//총 몇 번을 돌릴 것인지 확인
	getchar();//엔터값 저장=>무효화 처리

	Node* head = (Node*)malloc(sizeof(Node));//헤드 선언
	Node* leftNode = (Node*)malloc(sizeof(Node));
	Node* rightNode = (Node*)malloc(sizeof(Node));

	head->key = 'Z';//헤드 초기화
	head->left = NULL;//헤드 left와 right NULL로 변경
	head->right = NULL;

	for (i = 0; i < n; i++) {
		char parent, left, right;
		scanf("%c %c %c", &parent, &left, &right);
		getchar();//입력이 모두 되고 나서 엔터를 입력받기 위한 getchar
		if (i == 0) {//만약 첫번째면, 초기화를 한다.
			head->key = parent;
			if (left != '.') {
				head->left = leftNode;
				leftNode->key = left;
				leftNode->left = NULL;
				leftNode->right = NULL;
			}
			if (right != '.') {
				head->right = rightNode;
				rightNode->key = right;
				rightNode->left = NULL;
				rightNode->right = NULL;
			}
		}
		else {//첫 번째가 아니면 insert함수로 넘긴다.
			insert(head, parent, left, right);
		}
	}

	preorder(head);//전위 순회부터 중위 순회, 후위순회까지 모두 출력
	printf("\n");
	inorder(head);
	printf("\n");
	postorder(head);

	return 0;
}

void insert(Node* head, int key, char left, char right) {
	Node* leftNode = (Node*)malloc(sizeof(Node));
	Node* rightNode = (Node*)malloc(sizeof(Node));
	Node* pos = (Node*)malloc(sizeof(Node));//parent 노드의 위치를 찾아서 반환한 후 저장할 위치

	Node* temp = NULL;

	temp = SearchTree(head, key);
	if (pos == NULL) {
		printf("thisiswrong!!\n");
	}
	if (left != '.') {
		temp->left = leftNode;
		leftNode->key = left;
		leftNode->left = NULL;
		leftNode->right = NULL;
	}
	if (right != '.') {
		temp->right = rightNode;
		rightNode->key = right;
		rightNode->left = NULL;
		rightNode->right = NULL;
	}
}

void inorder(Node* ptr) {
	Node* point = (Node*)malloc(sizeof(Node));
	point = ptr;
	if (point != NULL) {
		inorder(point->left);
		printf("%c", point->key);
		inorder(point->right);
	}
}

void preorder(Node* ptr) {
	Node* point = (Node*)malloc(sizeof(Node));
	point = ptr;
	if (point != NULL) {
		printf("%c", point->key);
		preorder(point->left);
		preorder(point->right);
	}
}

void postorder(Node* ptr) {
	Node* point = (Node*)malloc(sizeof(Node));
	point = ptr;
	if (point != NULL) {
		postorder(point->left);
		postorder(point->right);
		printf("%c", point->key);
	}
}

Node* SearchTree(Node* node, char parent) {
	if (node != NULL) {
		if (node->key == parent)
			return node;
		else {
			Node* temp = SearchTree(node->left, parent);
			if (temp != NULL)
				return temp;
			return SearchTree(node->right, parent);
		}
	}
	return NULL;
}