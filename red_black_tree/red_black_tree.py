'''
Basic implementation of a Red Black Tree data structure in Python.

Implemented in Python 3.6
'''

class RedBlackTreeNode():
    '''
    Represents one node within a Red Black Tree.
    Each node has the following information:
    - Its color, which is either red or black, and is represented
      by two integers, 0 being red and 1 being black.
    - Its item, containing the data the node is meant to keep
    - Its parent node, a pointer to the node's parent node. If
      the node is a root node, its parent is None.
    - Its left and right children. If the node is a leaf,
      its left and right children are None.
    '''

    # These constants make it easy to know within the code
    # which integer is meant to be RED, and which one is BLACk
    RED = 0
    BLACK = 1

    def __init__(self, color, item, parent, left, right):
        self.color = color
        self.item = item
        self.parent = parent
        self.left = left
        self.right = right

    def is_root_node(self):
        return self.parent is None or self.parent.is_null_node()

    def is_leaf(self):
        none_children = self.left is None and self.right is None
        
        if not none_children:
            return self.left.is_null_node() and self.right.is_null_node()

        return False

    def is_null_node(self):
        return self.color == RedBlackTreeNode.BLACK and self.item is None

    def set_null_node(self):
        self.color = RedBlackTreeNode.BLACK
        self.item = None
        return self.is_null_node()

class RedBlackTree():
    pass

def main():
    print("This works!")

if __name__ == '__main__':
    main()
