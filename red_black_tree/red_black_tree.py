'''
Basic implementation of a Red Black Tree data structure in Python.

Implemented in Python 3.6
'''

# These constants make it easy to know within the code
# which integer is meant to be RED, and which one is BLACk
RED = 0
BLACK = 1

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

    def __init__(self, item, color=None, parent=None, left=None, right=None):
        '''
        Constructor of the class. Given a color, an item, and three other nodes
        that represent the parent node and left and right children, builds
        an instance of a Red Black Tree node with such information.
        '''

        self.color = color
        self.item = item
        self.parent = parent
        self.left = left
        self.right = right

    def is_root_node(self):
        '''
        Determines whether a node is the root of a tree,
        by checking if its parent node is None.
        '''

        return self.parent is None or self.parent.is_nil()

    def is_leaf(self):
        '''
        Determines whether a node is a leaf, by checking if both
        its children are None.
        '''

        none_children = self.left is None and self.right is None

        if not none_children:
            return self.left.is_nil() and self.right.is_nil()

        return True

    def is_nil(self):
        '''
        Checks whether a given, instantiated node equals to None.
        '''

        return self.color is None and self.item is None

    def __str__(self):
        rep = ""

        if self.left is not None and not self.left.is_nil():
            rep += str(self.left)
            rep += " "

        rep += str(self.item)

        if self.right is not None and not self.right.is_nil():
            rep += " "
            rep += str(self.right)

        return rep


def main():
    print("This works!")

if __name__ == '__main__':
    main()
