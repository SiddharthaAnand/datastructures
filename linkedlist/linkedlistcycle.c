#include <stdio.h>
#include <stdlib.h>

struct node {
	int data;
	struct node *next;
}

int checkForCycle(struct node **head) {
	struct node *temp = *head;
	// If the ptr is null ; no list
	if (temp == NULL) return -1;
	// If there is only one node
	if (temp->next == head) return 1;
	// Take two pointers and make it a slow and fast one.
	// 
	struct node *slow = *head;
	struct node *fast = slow->next;
	// No need to check for slow == NULL because if there
	// is a null at the end, then fast will always reach it
	// before the slow ptr.
	while (fast != NULL && fast->next != NULL && fast != slow) {
		slow = slow->next;
		fast = fast->next->next;
	}

	// Check all the conditions
	if (fast->next == NULL) printf("\n------No cycles present\n");
	if (fast == slow)       printf("-------Cycle is present\n");
}

// Method to create a node only.
struct node *newNode(int data) {
	struct node *temp = *head;
	// Create the first node
	new = (struct node *)malloc(sizeof(struct node));
	new->data = data;
	new->next = NULL;
	return new;
}

// Check for NULL head at the calling method
void appendEnd(struct node **head, struct node **new) {
	// If it is the first node
	struct node *temp = *head;
	// Run a loop till the last but one node and then insert
	// the new node.
	while (temp->next != NULL) {
		temp = temp->next;
	}
	// Now, insert the node
	temp->next = new;
}

// Print the Linked List
void printLinkedList(struct node **head) {
	if (head == NULL) printf("\n Linked List is NULL");
	struct node *temp = *head;
	while (temp != NULL) {
		printf("\nData: %d", temp->data);
		temp = temp->next;
	}
}

// Insertion of a LinkedList
void insert() {

}

int main() {

}