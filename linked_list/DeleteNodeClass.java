/* URL: https://practice.geeksforgeeks.org/problems/delete-without-head-pointer/1
 * // This function should delete node from linked list. The function
 * // may assume that node exists in linked list and is not last node
 */

class DeleteNodeClass
{
    void deleteNode(Node del)
    {
         // Your code here
         Node tmp = del.next;
         while (tmp.next != null) {
             del.data = tmp.data;
             del = del.next;
             tmp = tmp.next;
         }
         del.data = tmp.data;
         tmp = null;
         del.next = null;    
    }
}

