/* Question: Add two numbers represented as linkedlist in reverse order.
 */
class ListNode {
	int val;
	ListNode next;
	ListNode (int v) {
		val = v;
		next = null;
	}
}

class AddNumbersInLinkedList {
	// Handles both the cases where the number lists are of different/same length.
	// Store the result in a new list.
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null)
			return l1;
		ListNode result = null;
		ListNode res = null;
		int sum = 0;
		while (l1 != null || l2 != null) {
			sum = sum / 10;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			if (result == null) {
				result = new ListNode(sum % 10);
				res = result;
			}
			else {
				result.next = new ListNode(sum % 10);
				result = result.next;
			}

		}
		if ((sum / 10) > 0)
			result.next = new ListNode(sum / 10);
		return res;
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		ListNode l2 = new ListNode(3);
		l2.next = new ListNode(9);
		l2.next.next = new ListNode(8);
		ListNode res = addTwoNumbers(l1, l2);
		System.out.println();
		while (res != null) {
			System.out.print(" " + res.val + " ");
			res = res.next;
		}
		System.out.println();
	}


}