#include<stdio.h>
#include<stdlib.h>

void reverseee(char *s);

void reverseee(char *s)
{
   char *end;
   char temp;

   end = s;

   if(s)
   {
      while(*end)
         end++;

      end--;

      while(s < end)
      {
         temp = *s;
         *s = *end;
         *end = temp;
         s++;
         end--;
      }
   }
}

int main()
{
   char s[] = "Hello";
   printf("\nString before reverse: %s", s);
   reverseee(s);
   printf("\nString after reverse: %s\n", s);
   return 0;
}

