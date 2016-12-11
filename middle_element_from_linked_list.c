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
void free_list_iterative(struct node**);

/* Adding in the linked list */
void push(struct node** address_head, int data)
{
	struct node* new_node = (struct node *)malloc(sizeof(struct node));
	new_node->data = data;
	new_node->next = *address_head;
	*address_head = new_node;
	//return &address_head;
}

/* Printing the values in the linked list */
void print_list(struct node** address_head)
{
	struct node* temp = *address_head;
	if(temp == NULL)
		return;
	else
	{
		//print_list(&(temp->next));
		while(temp != NULL)
		{
			printf("%d ", temp->data);
			temp = temp->next;
		}
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

/* Print middle element in the linked list, for even length lists prints the floor(n/2) + 1 element */
void middle_element_linkedlist(struct node *head)
{
	/* Return nothing if the head is null or a single element */
	if(head == NULL || head->next == NULL)
		return;
	struct node *slow_ptr = head, *fast_ptr = head;

	/* Case 2: For lists of length larger than 1 */
	/* While condition for lists of odd length */
	while(fast_ptr->next != NULL)
	{
		slow_ptr = slow_ptr->next;
		fast_ptr = fast_ptr->next->next;
		/* For lists of even length */
		if(fast_ptr == NULL)
			break;
	}
	printf("%d \n", slow_ptr->data);
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
	push(&head, 7);
	printf("\n-------- list ------- \n");
	print_list(&head);
	printf("\n-------- Middle Element ------- \n");
	middle_element_linkedlist(head);
	free_list(&head);

}
