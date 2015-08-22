#include <stdio.h>
#include <stdlib.h>

struct node 
{
	int data;
	struct node *left_child;
	struct node *right_child;
};

/* Inserting elements in the BST */
void insert_elements(struct node** address_root, int data)
{
	struct node *current = *address_root, *prev;
	//Case 1: On reaching at the leaf or the first node of a BST
	if( current == NULL)
	{
		struct node* new_node = (struct node*)malloc(sizeof(struct node));
		new_node->data = data;
		new_node->right_child = new_node->left_child = NULL;
		*address_root = new_node;
		return;
	}
	//Case 2: Search the correct leaf to insert
	while(current != NULL)
	{
		//printf("%d %d\n", current->data, data);
		prev = current;
		if(current->data < data)
			current = current->right_child;
		else if(current->data > data)
			current = current->left_child;
	}
	//Correct position found
	struct node *new_node = (struct node *)malloc(sizeof(struct node));
	new_node->data = data;
	new_node->left_child = new_node->right_child = NULL;
	if(prev->data < data)
		prev->right_child = new_node;
	else
		prev->left_child = new_node;
}

/* Print the tree in inorder */
void print_tree_inorder(struct node **address_root)
{
	struct node *current = *address_root;
	if(current == NULL)
		return;
	print_tree_inorder(&(current->left_child));
	printf("%d \n", current->data);
	print_tree_inorder(&(current->right_child));
}

/* Search a value in the BST and returns that value */
int search_elements(struct node **address_root, int data)
{
	struct node *current = *address_root;
	if(current == NULL)
		return;
	if(current->data < data)
		search_elements(&(current->right_child), data);
	else if(current->data > data)
		search_elements(&(current->left_child), data);
	else
		return current->data;
}

int main()
{
	struct node *root = NULL;
	insert_elements(&root, 5);
	insert_elements(&root, 3);
	insert_elements(&root, 7);
	insert_elements(&root, 1);
	insert_elements(&root, 2);
	insert_elements(&root, 6);
	insert_elements(&root, 8);
	print_tree_inorder(&root);
}
