# Problem URL: https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
{
class Node:
    """ Class Node """
    def __init__(self, value):
        self.left = None
        self.data = value
        self.right = None
class Tree:  #Binary tree Class
    def createNode(self, data):
        return Node(data)
    
    def insert(self, node, data, ch):
        if node is None:
            return self.createNode(data)
        if(ch=='L'):
            node.left = self.insert(node.left, data, ch)
            return node.left
        else:
            node.right = self.insert(node.right, data, ch)
            return node.right
    def search(self, lis, data):
        # if root is None or root is the search data.
        for i in lis:
            if i.data == data:
                return i
    def traverseInorder(self, root):
        if root is not None:
            self.traverseInorder(root.left)
            print(root.data, end=" ")
            self.traverseInorder(root.right)
import sys            
def printDLL(head): #Print util function to print Linked List
    prev = None
    sys.stdout.flush()
    while(head != None):
        print(head.data, end=" ")
        prev=head
        head=head.right
    print('')
    while(prev != None):
        print(prev.data, end=" ")
        prev=prev.left
    print('')
    
if __name__=='__main__':
    t=int(input())
    for i in range(t):
        n=int(input())
        arr = input().strip().split()
        tree = Tree()
        lis=[]
        root = None
        root = tree.insert(root, int(arr[0]), 'L')
        lis.append(root)
        k=0
        for j in range(n):
            ptr = None
            ptr = tree.search(lis, int(arr[k]))
            lis.append(tree.insert(ptr, int(arr[k+1]), arr[k+2]))
            # print arr[k], arr[k+1], ptr
            k+=3
        # tree.traverseInorder(root)
        # print ''
        head = None #head to the DLL
        head = bToDLL(root)
        printDLL(head)

}
''' This is a function problem.You only need to complete the function given below '''
'''
class Node:
    """ Class Node """
    def __init__(self, value):
        self.left = None
        self.data = value
        self.right = None
'''

def leftMostNode(root):
    if root is None: return None
    if root.left is None: return root
    return leftMostNode(root.left)

def rightMostNode(root):
    if root is None: return None
    if root.right is None: return root
    return rightMostNode(root.right)


#Your task is to complete this function
#function should return head to the DLL
def bToDLL(root):
    if root is None: return None

    left = rightMostNode(bToDLL(root.left))
    root.left = left
    if left is not None:
        left.right = root

    right = bToDLL(root.right)
    root.right = right
    if right is not None:
        right.left = root
    return leftMostNode(root)
