/* This code creates a linked list and performs basic operations */
#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node* next;
};

void push(struct node **, int);
void print_list(struct node**);
void free_list(struct node**);
int length_ll(struct node*);
int length_linkedlist_recursive(struct node**);
void free_list_iterative(struct node**);

/* reverse a linked list */
void reverse_linked_list(struct node** address_head)
{
	//Case 1: If the list is empty or only one node
	if(*address_head == NULL || (*address_head)->next == NULL)
		return;
	//Case 2: More than one node
	struct node* prev = *address_head, *current = prev->next, *next_ptr;
	prev->next = NULL;
	while(current != NULL)
	{
		printf("\nReversing\n");
		next_ptr = current->next;
		current->next = prev;
		prev = current;
		current = next_ptr;
	}
	*address_head = prev;
}

/* Iterative implementation of the length of the linked list */
int length_ll(struct node* head)
{
	//struct node* temp = *head;
	int count = 0;
	while(head != NULL)
	{
		count++;
		head = head->next;
	}
	return count;
}

/* Adding in the linked list, if order not important*/
void push(struct node** address_head, int data)
{
	struct node* new_node = (struct node *)malloc(sizeof(struct node));
	new_node->data = data;
	new_node->next = *address_head;
	*address_head = new_node;
	//return &address_head;
}

/* Printing the values in the linked list in the order inserted*/
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
	printf("\n");
}

/* Freeing the nodes in the linked list, freeing the memory, Iterative */
void free_list_iterative(struct node** address_head)
{
	while(*address_head != NULL)
	{
		struct node* temp = *address_head;
		*address_head = (*address_head)->next;
		free(temp);
	}
}

/* Iterative implementation of the length of the linked list */
int length_linkedlist_recursive(struct node** head)
{
	if(*head == NULL) return 0;
	return length_linkedlist_recursive(&((*head)->next)) + 1;
}

/* Freeing the nodes in the linked list, freeing the memory, Recursive */
void free_list(struct node** address_head)
{
	int count = 0;
	//struct node* temp = *address_head;
	if(*address_head == NULL)
		return;
	count += 1;
	free_list(&((*address_head)->next));
	struct node* temp = (*address_head);
	(*address_head)->next = NULL;
	free(temp);
}

int main()
{
	struct node* head = NULL;
	push(&head, 1);
	push(&head, 2);
	push(&head, 3);
	push(&head, 4);
	push(&head, 5);
	push(&head, 6);
	//printf("\nLength of the list : %d\n", length_ll(head));
	//printf("\nLength of the list : %d\n", length_linkedlist_recursive(&head));
		
	//print_list(&head);
	reverse_linked_list(&head);
	print_list(&head);
	free_list(&head);

}
