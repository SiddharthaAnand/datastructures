// This denotes the usage of macro as well as the
// scope of the variable defined if the variables
// are the same.

#include <stdio.h>
#define SWAP(x, y) {\
int z = x;\
int x = y;\
int y = z;\
printf(" x = %d y = %d\n", x, y);\
}
int main() {
    int x = 3, y = 4;
    SWAP(x, y);
    // outside scope
    printf("x = %d y = %d\n", x, y);
}
