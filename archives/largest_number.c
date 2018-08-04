/*
Given a list of non negative integers, arrange them such that they form the largest number.

For example:

Given [3, 30, 34, 5, 9], the largest formed number is 9534330.

Note: The result may be very large, so you need to return a string instead of an integer.
*/
/*
There are 1 lines in the input

Line 1 ( Corresponds to arg 1 ) : An integer array. First number is the size S of the array. Then S numbers follow which indicate the elements in the array.
*/

/**
 * @input A : Read only ( DON'T MODIFY ) Integer array
 * @input n1 : Integer array's ( A ) length
 * */
 int compare(const void *a1,const void *b1){
    int a = *(int*)a1;
    int b = *(int*)b1;
    int i=0;
    char arr[10000]={0};
    char brr[10000]={0};
    sprintf(arr, "%d%d", a, b);
    sprintf(brr, "%d%d", b, a);
    int k = strlen(arr);
    for(i=0; i < k; i++){
        if(arr[i] != brr[i])
            return brr[i] - arr[i];
    }
    return b-a;
}
char* largestNumber(const int* A, int n1) {
    char *ans = (char*) calloc(10000000,sizeof(char));
    int i=0, count=0;
    qsort(A, n1, sizeof(int), compare);
    if(A[0] == 0){  
        ans[0] = '0'; ans[1]=0; return ans;
    }
    for(i=0; i<n1; i++){
        count += sprintf(ans+count, "%d", A[i]);
    }
    ans[count] = 0; //places null character
    return ans;
}

