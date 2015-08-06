/* This code creates a linked list and performs basic operations */
#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node* next;
};

void push(struct node **, int);
//struct node** create_node();
/*
struct node** create_node()
{
	struct node* new_node = (struct node *)malloc(sizeof(struct node));
	new_node->next = NULL;
	return &new_node;
}*/

void push(struct node** address_head, int data)
{
	struct node* new_node = (struct node *)malloc(sizeof(struct node));
	new_node->data = data;
	new_node->next = *address_head;
	*address_head = new_node;
	//return &address_head;
}

void print_list(struct node** address_head)
{
	struct node* temp = *address_head;
	if(temp == NULL)
		return;
	else
	{
		print_list(&(temp->next));
		printf("%d ", temp->data);
	}
}

void free_list(struct node** address_head)
{
	while(*address_head != NULL)
	{
		struct node* temp = *address_head;
		*address_head = (*address_head)->next;
		free(temp);
	}
}
/*
void free_list(struct node** address_head)
{
	int count = 0;
	//struct node* temp = *address_head;
	if(*address_head == NULL)
		return;
	count += 1;
	free_list(&((*address_head)->next));
	printf("\nsize of list : %lu\n", sizeof(struct node));
	struct node* temp = (*address_head);
	(*address_head)->next = NULL;
	free(temp);
}
*/
int main()
{
	struct node* head = NULL;
	push(&head, 1);
	push(&head, 2);
	push(&head, 3);
	push(&head, 4);
	push(&head, 5);
	print_list(&head);
	free_list(&head);
}
