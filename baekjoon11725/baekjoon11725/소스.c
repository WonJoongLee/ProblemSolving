/* �����̳� ť�� �Ἥ �ٽ� Ǯ��� �ҵ�
   �׽�Ʈ ���̽��� �߰��� �� ������
   3
   2 3
   1 2
   �� �׽�Ʈ ���̽��� ������ ����.
   bfs/dfs�� �ٽ� �����ϰ� �ٽ� Ǯ���
   200528-00:34 ù Ǫ��
*/

#include <stdio.h>

typedef struct node {
	int key;//��� ��ȣ�� ������ �ִ�.
	int chk;//chk�� 0�̸� forest��Ȳó�� Ʈ���� �ٸ� ���� ��ġ������
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
		if ((head->left != NULL) && (head->left->key == key))//����� left�� NULL�� �ƴϰ� key�� ã������ key���� ���� ��
			return head;
		else if ((head->right != NULL) && (head->right->key == key))
			return head;
		else {//���� head�� �ڳడ �ƴ϶��, �Ʒ� ����.
			Node* temp = SearchChildTree(head->left, key);//���� left Ž��
			if (temp != NULL)//������ ������ ���ٸ� NULL�̹Ƿ� �� �κ� �����ϰ� �Ѿ
							 //������ ���� �ƴϿ��� temp�� NULL�� �ƴ϶�� temp�� ��ȯ��. ���⼭ �Լ��� ����
				return temp;
			return SearchChildTree(head->right, key);//������ Ž��
		}
	}
	return NULL;
}

int chk(Node* node) {
	if (node->left->right == node) {
		return 2;//���� ���� ����, �� ���߿� ��������� �� �����.
	}
	else if (node->right->left == node) {
		return 1;
	}
	else
		return 0;//�� �� �ƴ� ��� 0 ��ȯ
}


int main() {
	int t, i, a, b;//a�� b�� �� ����
	Node* head = (Node*)malloc(sizeof(Node));
	head->left = NULL;
	head->right = NULL;
	head->key = 1;//��Ʈ�� 1�� �ʱ�ȭ �Ѵ�.
	scanf("%d", &t);

	for (i = 0; i < t - 1; i++) {
		Node* pos = (Node*)malloc(sizeof(Node));//Ž���� ����� ��ġ�� ������ �ӽ� ����
		Node* newNode = (Node*)malloc(sizeof(Node));//���� �߰��� ����.
		Node* newNode2 = (Node*)malloc(sizeof(Node));//���� �߰��� ����.
		newNode->left = NULL;
		newNode->right = NULL;

		scanf("%d %d", &a, &b);

		pos = SearchTree(head, a);//���� Ʈ������ a�� �ִ��� Ž���Ѵ�.

		if (pos != NULL) {
			if (pos->left == NULL) {//���� ���� ��尡 ������� ���� ��忡 ����
				if (chk(pos) == 1) {//���� ���߿� ������ִ� �����̶��
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
			else if (pos->right == NULL) {//������ ��尡 ������� ������ ��忡 ����
				if (chk(pos) == 1) {//���� ���߿� ������ִ� �����̶��
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
			pos = SearchTree(head, b);//���� Ʈ������ a�� ��ã�����Ƿ� b�� �ִ��� Ž���Ѵ�.
			if (pos != NULL) {//���� Ʈ������ b�� ã������ �Ʒ� ���ǹ� ����
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
			else if (pos == NULL) {//a�� b�� �� �� ã�� �������� �Ʒ� ���ǹ� ����
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
		Node* pos = (Node*)malloc(sizeof(Node));//Ž���� ����� ��ġ�� ������ �ӽ� ����
		pos = SearchChildTree(head, i);
		printf("%d\n", pos->key);
	}
	return 0;
}

