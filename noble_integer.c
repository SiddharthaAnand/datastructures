/* Question: Given an integer array, find if an integer p exists in the array such that the number of integers greater than p in the array equals to p
 If such an integer is found return 1 else return -1. 
 
 There are 1 line in the input
 Line 1 ( Corresponds to arg 1 ) : An integer array. First number is the size S of the array. Then S numbers follow which indicate the elements in the array.
 
 */
 
/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer
 */
 
int comp (const void * elem1, const void * elem2) 
{
    int f = *((int*)elem1);
    int s = *((int*)elem2);
    if (f > s) return  1;
    if (f < s) return -1;
    return 0;
}
int solve(int* A, int n1) {
    qsort (A, n1, sizeof(int), comp);
    int i;
    for(i = 0; i < n1 - 1; i++) {
        if(A[i] != A[i+1] && A[i] == (n1 - i - 1)) return 1;
    }
    if(A[n1-1] == 0) return 1;
    return -1;
}
