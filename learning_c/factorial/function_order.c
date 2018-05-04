#include <stdio.h>

int add(int,int);

int main(void) {
  int a = add(2,3);
  printf("hello\n");
  printf("%d\n",a);
  return 0;
}

int add(int a,int b){
  return a+b;
}
