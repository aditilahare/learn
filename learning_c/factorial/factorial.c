#include <stdio.h>

int fact(int num){
  if(num==0){
    return 1;
  }
  return num*fact(num-1);
}

int main(){
  int result = fact(5);
  printf("The factorial of 5 is %d \n",result);
  return 0;
}
