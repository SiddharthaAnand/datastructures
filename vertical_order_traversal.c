/**
Given a binary tree, print a vertical order traversal of it.

Example :
Given binary tree:
      6
    /   \
   3     7
  / \     \
 2   5     9

returns
[
    [2],
    [3],
    [6 5],
    [7],
    [9]
]

Note : If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
**/
/**
 * Definition for binary tree
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 * 
 * typedef struct TreeNode treenode;
 * 
 * treenode* treenode_new(int val) {
 *     treenode* node = (treenode *) malloc(sizeof(treenode));
 *     node->val = val;
 *     node->left = NULL;
 *     node->right = NULL;
 *     return node;
 * }
 */
 
/**Input
There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : Serialized representation of tree. The serialization of a binary tree follows a level order description of left and right child of nodes, where -1 signifies a NULL child.
	For example,
		 1
		/ \ 
	       2    3
		  /
		4
		 \
		  5
	will have representation as {1 2 3 -1 -1 4 -1 -1 5 -1 -1}
	The first integer on the line indicates the number of integers to follow in the serialized representation of the tree.
**/

/**
 * @input A : Root pointer of the tree 
 * 
 * @Output 2D int array. You need to malloc memory. Fill in len1 as row, len2 as columns 
 */

/* Compute the "maxDepth" of a tree -- the number of 
    nodes along the longest path from the root node 
    down to the farthest leaf node.*/
int maxDepth(treenode* node) 
{
   if (node==NULL) 
       return 0;
   else
   {
       /* compute the depth of each subtree */
       int lDepth = maxDepth(node->left);
       int rDepth = maxDepth(node->right);
 
       /* use the larger one */
       if (lDepth > rDepth) 
           return(lDepth+1);
       else return(rDepth+1);
   }
} 


void fillArray(int** arr, treenode *A, treenode* B, int height, int* count) {
    if(A == NULL || B == NULL) return;
    
    //printf("B->val+height=%d\n", B->val+height);
    arr[B->val+height][count[B->val+height]++] = A->val;
    fillArray(arr, A->left, B->left, height, count);
    
    fillArray(arr, A->right, B->right, height, count);
}

void inOrder(treenode *A, treenode *B, int* min, int* max) {
    if(A == NULL) return;
    
    B->left = treenode_new(B->val - 1);
    inOrder(A->left, B->left, min, max);
    
    //printf("A: %d, B: %d\n", A->val, B->val);
    if(B->val > *max) {
        *max = B->val;
    }
    if(B->val < *min) {
        *min = B->val;
    }
    
    B->right = treenode_new(B->val + 1);
    inOrder(A->right, B->right, min, max);
}

int ** verticalOrderTraversal(treenode* A, int *len1, int *len2) {
    int i, j;
   
    treenode* B = treenode_new(0);;
    treenode* temp1 = A;
    treenode* temp2 = B;
    int min = 0, max = 0;
    inOrder(temp1, temp2, &min, &max);
 
    
    temp1 = A;
    int height = maxDepth(temp1);

    *len1 = max - min + 1;
    *len2 = height;

    int **arr = (int**)malloc(*len1 * sizeof(int*));
    for(i=0; i<*len1; i++) {
        arr[i] = (int*)malloc(*len2 * sizeof(int));
    }
    int* count = (int*)calloc(*len1, sizeof(int));
    temp1 = A;
    temp2 = B;
    fillArray(arr, temp1, temp2, -min, count);
    
    int **arr2 = (int**)malloc(*len1 * sizeof(int*));
    for(i=0; i<*len1; i++) {
        arr2[i] = (int*)malloc(count[i] * sizeof(int));
    } 
    for(i=0; i<*len1; i++) {
        for(j=0; j<count[i]; j++){
            arr2[i][j] = arr[i][j];
        }
    }

    printf("[\n");
    for(i=0; i<*len1; i++) {
        printf("    [");
        for(j=0; j<count[i]; j++){
            printf("%d ", arr2[i][j]);
        }
        if(i==(*len1-1)) printf("]\n");
        else printf("],\n");
    }
    printf("]");
    return arr2;
}
