/* Given an array of integers, sort the array into a wave like array and return it, 
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5..... */

/* There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : An integer array. First number is the size S of the array. Then S numbers follow which indicate the elements in the array.
    For example, Array: [1, 2, 6] will be written as "3 1 2 6"(without quotes).

*/

/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in len1
 */
 
int comp (const void * a, const void * b)
{
   return ( *(int*)a - *(int*)b );
}
int* wave(int* A, int n1, int *len1) {
    qsort(A, n1, sizeof(int), comp);
    int* ret = (int*)malloc(sizeof(int) * n1);
    int i;
    for(i=0; i< n1 - 1; i+=2) {
       ret[i] = A[i+1];
       ret[i+1] = A[i];
       printf("%d %d ", ret[i], ret[i+1]);
    }
    if(n1%2 == 1) {
        ret[n1-1] = A[n1-1];
        printf("%d ", ret[n1-1]);
    }
    return ret;
}
