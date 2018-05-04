#include <stdio.h>

// int main() {
//   char e = 'o';
//   char d = 'l';
//   char c = 'l';
//   char b = 'e';
//   char a = 'h';
//   printf("%s\n",&a);
//   return 0;
// }


// int string_length(){
//
// }

int main() {
  char* a = "aditi";
  printf("%c\n",*a);
  printf("%p\n",a);

  printf("%c\n",*(++a));
  printf("%p\n",a);

  printf("%c\n",*(++a));
  printf("%p\n",a);

  printf("%c\n",*(++a));
  printf("%p\n",a);

  printf("%c\n",*(++a));
  printf("%p\n",a);

  return 0;
}
