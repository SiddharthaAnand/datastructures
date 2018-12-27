/* URL: https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * // This function should delete node from linked list. The function
 * // may assume that node exists in linked list and is not last node
 */

class DeleteNodeClass
{
    void deleteNode(Node del) {	
	     del.data = del.next.data;
	     del.next = del.next.next;
    }
}

