#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

unsigned long long max(unsigned long long a, unsigned long long b) {
   if (a > b)
       return a;
   return b;
}
int main() {
   unsigned long long N, a[1000000], i, j, count[1000000], length = 0;
   scanf("%llu", &N);
   if(N==0) {
       printf("%llu", length);
       return 0;
   }
   for(i=0; i<N; i++) {
       scanf("%llu", &a[i]);
       count[i] = 0;
   }
   count[0] = 1;
   length = 1;
   for(i=1; i<N; i++) {
      count[i] = 1;
      for(j=0; j<i; j++) {
          if(a[i] > a[j]) {
              count[i] = max(count[i], count[j] + 1);
          }
      }
      length = max(count[i], length);
   }
   printf("%llu", length);
   return 0;
}