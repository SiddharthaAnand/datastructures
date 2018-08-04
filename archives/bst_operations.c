#include <stdio.h>
#include <stdlib.h>

struct node
{
	float data;
	struct node *left;
	struct node *right;
};


/*
Method to find LCA in BST assuming n1 and n2 are present in the BST.
*/

int lca(struct node *root, int n1, int n2)
{
	struct node *temp = root;
	if(!root) return;
	if(n1 > n2)
	{
		n1 = n1 + n2;
		n2 = n1 - n2;
		n1 = n1 - n2;
	}
	while(root)
	{
		if(temp->data > n1 && temp->data < n2)
			printf("LCA of %d and %d : %d\n", n1, n2, temp->data);
		else if(temp->data < n1)
			temp = temp->right;
		else if(temp->data > n2)
			temp = temp->left;
	}
}

/*
Method to create a new node and return the pointer to the node.
*/

struct node *new_node(float data)
{
	struct node *newNode = (struct node *)malloc(sizeof(struct node));
	newNode->data = data;
	return newNode;
}

void delete_recursive(struct node *root, float data)
{
}

void delete_iterative(struct node *root, float data)
{
}

void search_recursive(struct node *root, float data)
{
}

void search_iterative(struct node *root, float data)
{
}


void insert_recursive(struct node *root, float data)
{	


}
/*
Method to insert the data, which is always at the leaves. 
First, finds a place where the data should be inserted.
*/

void insert_data(struct node *root, float data)
{
	struct node *temp = root, *prev = NULL;
	struct node *newNode = new_node(data);
	while(temp != NULL)
	{
		prev = temp;
		if(temp->data < data)
			temp = temp->right;
		else
			temp = temp->left;
	}
	if(prev->data > data)
		prev->left = newNode;
	else
		prev->right = newNode; 
}

void postorder(struct node *root)
{
}

void preorder(struct node *root)
{
}

/*
prints the bst in inorder formt.
*/

void inorder(struct node *root)
{
	struct node *temp = root;
	if(!temp)
		return;
	inorder(temp->left);
	printf(" %f ", temp->data);
	inorder(temp->right);
}
	
int main()
{
	struct node *root = new_node(5);
	insert_data(root, 5);
	
	insert_data(root, 4);
	insert_data(root, 3);
	insert_data(root, 10);
	insert_data(root, 9);
	insert_data(root, 4);
	insert_data(root, 6);
	inorder(root);
}
