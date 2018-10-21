# encoding=utf-8

'''
Basic implementation of a Red Black Tree data structure in Python.
Implemented in Python 3.6

Source:
    Cormen, T. et al. "Introduction to Algorithms", 2nd Edition

Author:
    Andrés Ignacio Torres
    @aitorres on github
    @andresitorresm on twitter
'''

# Importing randint for the test client, not really
# needed for the data structure
from random import randint

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

        # A node has either None as its parent, or a nil node marked
        # as such as its parent.
        return self.parent is None or self.parent.is_nil()

    def is_leaf(self):
        '''
        Determines whether a node is a leaf, by checking if both
        its children are None.
        '''

        # A leaf has either None as its two children, or two
        # nil nodes as the children. This variable checks for the first
        # condition
        none_children = self.left is None and self.right is None

        if none_children:
            return True

        # We check the second condition and return its appropriate value
        return self.left.is_nil() and self.right.is_nil()

    def is_nil(self):
        '''
        Checks whether a given, instantiated node equals to None.
        '''

        # A nil node has no color and no value
        return self.color is None and self.item is None

    def __str__(self):
        '''
        Returns an appropriate string representation of the current node
        as well as its children sub-trees, recursively.

        The string representation is performed following an in-order path
        along the tree.
        '''

        # We start with an empty string
        rep = ""

        # If the left sub-tree is not empty, print it
        if self.left is not None and not self.left.is_nil():
            rep += str(self.left)
            rep += " "

        # We add the current node item
        rep += str(self.item)

        # If the right sub-tree is not empty, print it
        if self.right is not None and not self.right.is_nil():
            rep += " "
            rep += str(self.right)

        # We return the appropriate representation we have found
        return rep

class RedBlackTree():
    '''
    Implements a red-black tree data structure, allowing for
    search, insertion and deletion in a balanced way.

    For more information, read Cormen's "Introduction to Algorithms",
    Chapter 13.
    '''

    def __init__(self):
        '''
        Constructor of a red-black tree.
        It sets the tree's size as 0 given that it's empty;
        it also instantiates an special nil node to be used
        within the insertion, search and deletion algorithms.

        It finally sets the nil node as the current root.
        '''

        self.nil = RedBlackTreeNode(None)
        self.root = self.nil
        self.size = 0

    def insert_key(self, key):
        '''
        Auxiliary method to insert a key. It just instantiates a
        red black tree node with the given key and passes it to the
        fully implemented, insert method.
        '''

        node = RedBlackTreeNode(key)
        self.insert(node)

    def insert(self, z):
        '''
        Inserts a red-black tree node within the current red-black tree.
        It performs the proper rotations needed to keep the tree balanced.
        '''

        y = self.nil
        x = self.root

        # We look for the appropriate place to insert the tree
        while x is not self.nil:
            y = x
            if z.item < x.item:
                x = x.left
            else:
                x = x.right

        # We set the node's temporary place
        z.parent = y
        if y is self.nil:
            self.root = z
        elif z.item < y.item:
            y.left = z
        else:
            y.right = z

        # We set the node's current properties and add one to the
        # tree's size
        z.left = self.nil
        z.right = self.nil
        z.color = RED
        self.size += 1

        # The insert_fixup methods will fix any unbalance added
        # because of setting the node's color as red
        self.insert_fixup(z)

    def insert_fixup(self, z):
        '''
        Detects and corrects any unbalance within the tree due to a recently
        performed insertion, regarding the amount of red and black nodes,
        and the red-black tree property:
            For each node, all paths from the node to descendant leaves contain the same number
            of black nodes.

        The method performs all the recoloring and rotations needed.
        '''

        # Due to the tree's properties, no parent-and-child pair
        # of nodes can be both red.
        while z.parent.color == RED:
            if z.parent == z.parent.parent.left:
                y = z.parent.parent.right
                if y.color == RED:
                    z.parent.color = BLACK
                    y.color = BLACK
                    z.parent.parent.color = RED
                    z = z.parent.parent
                else:
                    if z == z.parent.right:
                        z = z.parent
                        self.left_rotate(z)
                    z.parent.color = BLACK
                    z.parent.parent.color = RED
                    self.right_rotate(z.parent.parent)
            else:
                y = z.parent.parent.left
                if y.color == RED:
                    z.parent.color = BLACK
                    y.color = BLACK
                    z.parent.parent.color = RED
                    z = z.parent.parent
                else:
                    if z == z.parent.left:
                        z = z.parent
                        self.right_rotate(z)
                    z.parent.color = BLACK
                    z.parent.parent.color = RED
                    self.left_rotate(z.parent.parent)

        # If the root of the tree was changed, make sure it's a
        # black node.
        self.root.color = BLACK

    def left_rotate(self, x):
        '''
        Rotates a node's children to the left with a constant
        amount of pointer changes to preserve the tree's balance.
        '''

        y = x.right
        x.right = y.left
        if y.left is not self.nil:
            y.left.parent = x
        y.parent = x.parent
        if x.parent is self.nil:
            self.root = y
        elif x == x.parent.left:
            x.parent.left = y
        else:
            x.parent.right = y
        y.left = x
        x.parent = y

    def right_rotate(self, x):
        '''
        Rotates a node's children to the right with a constant
        amount of pointer changes to preserve the tree's balance.
        '''

        y = x.left
        x.left = y.right
        if y.right is not self.nil:
            y.right.parent = x
        y.parent = x.parent
        if x.parent is self.nil:
            self.root = y
        elif x == x.parent.right:
            x.parent.right = y
        else:
            x.parent.left = y
        y.right = x
        x.parent = y


    def __str__(self):
        '''
        Returns an appropriate string representation for a red-black tree.
        '''

        # Given that any node's string representation prints the given
        # node's sub-tree, all we have to do is print the root's sub-tree.
        return str(self.root)

def main():
    print("RED BLACK TREE IMPLEMENTATION TEST CLIENT")
    # Instantiating a red-black tree and finding 15 random integer values
    print("TEST CLIENT:\tInstantiating red-black tree.")
    tree = RedBlackTree()
    values = [randint(-1000, 1000) for i in range(0, 15)]

    print("TEST CLIENT:\tInserting 15 random integers in the range [-1000, 1000)")
    # Inserting the values
    for value in values:
        tree.insert_key(value)

    print("TEST CLIENT:\tPrinting the tree in order:")
    print(tree)

if __name__ == '__main__':
    main()
