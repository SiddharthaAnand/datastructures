#include <stdio.h>
#include <stdlib.h>

struct node 
{
	int data;
	struct node *left_child;
	struct node *right_child;
};

int max(int a, int b)
{
	return a > b ? a : b;
}

/* height of the BST */
int height_BST(struct node* root)
{
	if(root == NULL)
		return 0;
	else
		return max(height_BST(root->left_child), height_BST(root->right_child)) + 1;
}

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
	//Case 2: Search the correct leaf to insert, including equal valued elements.
	while(current != NULL)
	{
		
		prev = current;
		if(current->data < data)
			current = current->right_child;
		// equal values goes in the right tree
		else if(current->data >= data)
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
void print_tree_inorder(struct node *root)
{
	if(root == NULL)
		return;
	print_tree_inorder(root->left_child);
	printf("%d ", root->data);
	print_tree_inorder(root->right_child);
}

/* Print the tree in postorder, there will be no change in the root so no need of sending the address of the root */
void print_tree_postorder(struct node *root)
{
	if(root == NULL)
		return;
	print_tree_postorder(root->left_child);
	print_tree_postorder(root->right_child);
	printf("%d ", root->data);

}

/* Print the tree in preorder, there will be no change in the root so no need of sending the address of the root */
void print_tree_preorder(struct node *root)
{
	if(root == NULL)
		return;
	printf("%d ", root->data);
	print_tree_preorder(root->left_child);
	print_tree_preorder(root->right_child);
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
	/*
	1. Inserting the elements.
	2. Searching the elements.
	3. Inroder, postorder and preorder.
	4. Height of the tree.
	*/
	struct node *root = NULL;
	insert_elements(&root, 5);
	insert_elements(&root, 5);
	insert_elements(&root, 3);
	insert_elements(&root, 7);

	printf("\nHeight of the BST: %d\n", height_BST(root) - 1);
	insert_elements(&root, 1);
	insert_elements(&root, 2);
	insert_elements(&root, 6);
	insert_elements(&root, 8);
	print_tree_inorder(root);
	printf("\n");
	//print_tree_postorder(root);
	insert_elements(&root, 22);
	print_tree_postorder(root);
	printf("\n");
	print_tree_preorder(root);
	printf("\n");
	// A tree with only the root is of height 0
	printf("\nHeight of the BST: %d\n", height_BST(root) - 1);
	printf("\n%d\n", search_elements(&root, 4));
}
