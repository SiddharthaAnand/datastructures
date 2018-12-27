/* URL: https://practice.geeksforgeeks.org/problems/check-for-balanced-tree/1/?ref=self
 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
 * Improve the time complexity of the solution.
 */


import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.io.*;
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
}
class HeightBalancedTree
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {	
			
		int n1 = sc.nextInt();
                int n2 = sc.nextInt();
		char lr= sc.next().charAt(0);
				
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null)
                {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
			
            GfG g = new GfG();
			
			//boolean res = g.isHeap(root);
			if(g.isBalanced(root) == true)
			System.out.println(1);
			else 
			System.out.println(0);
			//CLN.inorder(root);
			 t--;
			// System.out.println();
        }
    }
}
}

/*Please note that it's Function problem i.e.
you need to write your solution in the form of Function(s) only.
Driver Code to call/invoke your function is mentioned above.*/

/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
class GfG
{
    int height(Node root) {
        if (root == null)
            return 0;
        int l =  1 + height(root.left);
        int r = 1 + height(root.right);
        
        if(l < r)
            return r;
        return l;
    }
    
     /* This function should return tree if passed  tree 
     is balanced, else false.  Time complexity should
     be O(n) where n is number of nodes in tree */
    boolean isBalanced(Node root)
    {
	if (root == null)
            return true;
            
        int left = height(root.left);
        int right = height(root.right);
        
        if (Math.abs(left - right) <= 1 &&
            isBalanced(root.left) &&
            isBalanced(root.right)) {
            return true;
        }
        else
        return false;
	
    }
}
