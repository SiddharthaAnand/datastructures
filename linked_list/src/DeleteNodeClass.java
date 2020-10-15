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

    /* URL: https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1/?ref=self
     */
    void linksort(Node head) {
		int zero = 0, one = 0, two = 0;
		Node tmp = head;
		while (head != null) {
		    if (head.value == 0) zero++;
		    if (head.value == 1) one++;
		    if (head.value == 2) two++;
		    head = head.next;
		}
		while (tmp != null) {
		    while (zero > 0) {
		        zero--;
		        tmp.value = 0;
		        tmp = tmp.next;
		    }
		    while (one > 0) {
		        one--;
		        tmp.value = 1;
		        tmp = tmp.next;
		    }
		    while (two > 0) {
		        two--;
		        tmp.value = 2;
		        tmp = tmp.next;
		    }
		}
	}  
}

