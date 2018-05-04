#include <stdio.h>

int main(){
  int a=5;
  int *b;
  b = &a;
  printf("b refers the value %d\n",*b);
  printf("b refers the address of a is %p\n",b);
  printf("The address of b is %p\n",&b);
  printf("The value of a is %d\n",a);
  printf("The address of a is %p\n",&a);
  return 0;
}
