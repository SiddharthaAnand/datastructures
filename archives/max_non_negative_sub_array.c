/**
 * @input A : Integer array
 * @input n1 : Integer array's ( A ) length
 * 
 * @Output Integer array. You need to malloc memory, and fill the length in length_of_array
 */
 
typedef unsigned long long llu;
 
typedef struct data {
    llu sum;
    int length;
    int lower;
    int higher;
}data;

data compare(data oldd, data newd) {
    if(newd.sum > oldd.sum) {
        return newd;
    }
    if(newd.sum == oldd.sum) {
        if(newd.length > oldd.length) {
            return newd;
        }
        if(newd.length == oldd.length) {
            if(newd.lower < oldd.lower) {
                return newd;
            }
        }
    }
    return oldd;
}

int* maxset(int* A, int n1, int *length_of_array) {
    /*
     * Sample Code : 
     *  *length_of_array = 1;
     *  int * ret = (int *) malloc(sizeof(int) * *length_of_array);
     *  ret[0] = 1;
     *  return ret;
     */
    
    int i;
    data old_data = {0, 0, 0, 0}, new_data = {0, 0, 0, 0};
    
    for(i=0; i<n1; i++) {
        if(A[i] < 0) {
            old_data = compare(old_data, new_data);
            new_data.sum = 0;
            new_data.length = 0;
            new_data.lower = i + 1;
            new_data.higher = i + 1;
        } else {
            new_data.sum += A[i];
            new_data.length += 1;
            new_data.higher = i;
        }
    }

    old_data = compare(old_data, new_data);
    length_of_array = (int *)malloc((old_data.higher - old_data.lower + 1) * (sizeof(int)));
    
    for (i = old_data.lower; i<= old_data.higher; i++) {
        if(A[i] < 0) break;
        length_of_array[i - old_data.lower] = A[i];
        printf("%d ", length_of_array[i - old_data.lower]);
    } 
    
    return length_of_array;
}
