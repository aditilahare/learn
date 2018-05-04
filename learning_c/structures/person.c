#include "stdio.h"
#include "stdlib.h"

typedef struct person{
  int age;
  int score;
}PERSON_INFO;

void print_as(struct person *aditi){
  printf("%d\n",aditi->age);
  printf("%d\n",aditi->score);
  printf("%p\n",&aditi);
}

int main() {
  PERSON_INFO aditi;
  aditi.age = 19;
  aditi.score = 100;
  print_as(&aditi);

  int* dhana = malloc(sizeof(int));
  *dhana = 200;
  printf("%p\n",dhana);
  printf("%d\n",*dhana);
  printf("%p\n",&dhana);
  return 0;
}
