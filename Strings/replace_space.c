
#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int main(int argc, char **argv)
{
   char *str;

   int i, j, len;

   str = argv[1];

   len = strlen(str);

   for (i = 0; i < len; i++)
   {
      if ( str[i] == ' ' )
      {
         j = len + 1;
         while( j > i )
	 {
	    *(str+j) = str[j-2];
	    j--;
	 }

	 str[i++] = '%';
	 str[i++] = '2';
	 str[i] = '0';

	 len = len + 2;

	 str[len] = NULL;
      }
   }

   printf("\nFinal String after replacement is \"%s\".\n", str);

}
