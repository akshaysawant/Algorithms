
#include <stdio.h>


void rotate(int a[5][5], int N, int b[5][5]);


int main()
{
   int a[5][5], b[5][5];
   int N = 5, i, j, k = 1;


   for(i = 0; i < N; i++)
   {
      for(j = 0; j < N; j++)
         a[i][j] = k++;
   }

   printf("\nInitial matrix is : ");

   for(i = 0; i < N; i++)
   {
      printf("\n");
      for(j = 0; j < N; j++)
         printf("%d   ", a[i][j]);
   }

   printf("\n\nRotating matrix.\n\n");
   rotate(a, N, b);

   printf("Matrix after rotation is : ");

   for(i = 0; i < N; i++)
   {
      printf("\n");
      for(j = 0; j < N; j++)
         printf("%d   ", b[i][j]);
   }

   printf("\n");
}



void rotate(int a[5][5], int N, int b[5][5])
{
   int i, j, newj;

   for (i = 0; i < N; i++)
   {
      newj = N - i - 1;

      for (j = 0; j < N; j++)
         b[j][newj] = a[i][j];
   }
}




