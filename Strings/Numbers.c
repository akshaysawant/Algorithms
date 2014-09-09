

#include <stdio.h>

int main (int argc, char *argv[])
{

   int N;// = atoi(*argv[1]);
   int i, j;

   printf ("Enter an integer : ");
   scanf ("%d", &N);

   for (i = 0; i < (2*N-1); i++)
   {
      int m = i, n = 0;
      for (j = 0; j < (2*N-1); j++)
      {
	 printf ("%d", N-m-n);
	 if (n < m)
	    n++;
	 else
	    n--;
      }

      if (m < N)
         m++;
      else
         m--;

      printf ("\n");
   }

}
