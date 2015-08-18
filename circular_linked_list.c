#include <stdio.h>
#include <stdlib.h>

struct node
{
	int data;
	struct node *next;
};

struct node *create_new_node(int data)
{
	struct node *new_node = (struct node *)malloc(sizeof(struct node));
	new_node->data = data;
	new_node->next = NULL;
	return new_node;
}

void create_clinked_list(struct node **add_head, int data)
{
	struct node *temp = *add_head, *prev = *add_head;
	//Case 1
	if(temp == NULL)
	{
		struct node *new_node = create_new_node(data);
		new_node->next = new_node;
		*add_head = new_node;
	}
	//Case 2: Insertion at the head
	else if(temp->data >= data)
	{
		while(temp->next != *add_head)
		{
			temp = temp->next;
		}
		struct node *new_node = create_new_node(data);
		new_node->next = *add_head;
		temp->next = new_node;
		*add_head = new_node;
	}
	//Case 3: Insertion in the middle
	else
	{
		while(temp->next != *add_head && temp->next->data < data)
		{
			temp = temp->next;
		}
		struct node *new_node = create_new_node(data);
		new_node->next = temp->next;
		temp->next = new_node;
	}
}

void print_clinked_list(struct node *head)
{
	if(head == NULL)
		return;
	struct node *curr = head;
	printf("%d ",curr->data);
	curr = curr->next;
	while(curr->next != head)
	{
		printf("%d ",curr->data);
		curr = curr->next;
	}
	printf("\n");
}

int main()
{
	struct node *head = NULL;
	create_clinked_list(&head, 1);
	create_clinked_list(&head, 2);
	create_clinked_list(&head, 3);
	create_clinked_list(&head, 3);
	print_clinked_list(head);
	create_clinked_list(&head, 4);
	create_clinked_list(&head, 5);
	create_clinked_list(&head, 6);
	create_clinked_list(&head, 1);
	print_clinked_list(head);
	//delete_clinked_list(&head);
}
