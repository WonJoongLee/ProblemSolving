#include <stdio.h>
#include <stdlib.h>

typedef struct node {
	int key;//���ĺ��� �����Ѵ�.
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

	scanf("%d", &n);//�� �� ���� ���� ������ Ȯ��
	getchar();//���Ͱ� ����=>��ȿȭ ó��

	Node* head = (Node*)malloc(sizeof(Node));//��� ����
	Node* leftNode = (Node*)malloc(sizeof(Node));
	Node* rightNode = (Node*)malloc(sizeof(Node));

	head->key = 'Z';//��� �ʱ�ȭ
	head->left = NULL;//��� left�� right NULL�� ����
	head->right = NULL;

	for (i = 0; i < n; i++) {
		char parent, left, right;
		scanf("%c %c %c", &parent, &left, &right);
		getchar();//�Է��� ��� �ǰ� ���� ���͸� �Է¹ޱ� ���� getchar
		if (i == 0) {//���� ù��°��, �ʱ�ȭ�� �Ѵ�.
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
		else {//ù ��°�� �ƴϸ� insert�Լ��� �ѱ��.
			insert(head, parent, left, right);
		}
	}

	preorder(head);//���� ��ȸ���� ���� ��ȸ, ������ȸ���� ��� ���
	printf("\n");
	inorder(head);
	printf("\n");
	postorder(head);

	return 0;
}

void insert(Node* head, int key, char left, char right) {
	Node* leftNode = (Node*)malloc(sizeof(Node));
	Node* rightNode = (Node*)malloc(sizeof(Node));
	Node* pos = (Node*)malloc(sizeof(Node));//parent ����� ��ġ�� ã�Ƽ� ��ȯ�� �� ������ ��ġ

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