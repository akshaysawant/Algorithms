#include <stdlib.h>

int main()
{
    char *str = "blablabla";
    char c = 'H';

    size_t len = strlen(str); /* could use 'sizeof' instead of strlen in this example */
    char *str2 = malloc(len + 1 + 1 ); /* one for extra char, one for trailing zero */
    strcpy(str2, str);
    str2[len - 2] = c;
    str2[len - 1] = '\0';

    printf( str2 ); /* prints "blablablaH" */

    free( str2 );
}
