#include <stdio.h>
#include <string.h>

int main()
{
    char str[50];
    char str1[50];
    char str2[50];
    char str3[50];
    printf("Enter a string: ");
    scanf("%[^\n]%*c", str);
    printf("The string is %s\n", str);
    int n = strlen(str);
    for (int i = 0; i < n; i++)
    {
        printf("ASCII for %c: %d\n", str[i], str[i]);
    }

    for (int i = 0; i < n; i++)
    {
        str1[i] = str[i] & 127;
    }
    str1[n] = '\0';
    printf("After doing AND --> %s", str1);
    printf("\n");

    for (int i = 0; i < n; i++)
    {
        str2[i] = str[i] | 127;
    }
    str2[n] = '\0';
    printf("After doing OR --> %s", str2);
    printf("\n");

    for (int i = 0; i < n; i++)
    {
        str3[i] = str[i] ^ 127;
    }
    str3[n] = '\0';
    printf("After doing XOR --> %s", str3);
    printf("\n");

    return 0;
}