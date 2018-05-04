#include <stdio.h>

int main() {
  int a, b, c;
  printf("give your input\n");
  scanf("%d",&a);
  printf("this is the value of a %d\n",a);
  scanf("%d",&b);
  printf("this is the value of b %d\n",b);
  scanf("%d",&c);
  printf("this is the value of c %d\n",c);
  c = a + b;
  printf("%d + %d = %d\n", a, b, c);
  return 0;
}
