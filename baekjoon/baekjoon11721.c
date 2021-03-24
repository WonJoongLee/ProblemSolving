#include <stdio.h>
char a[100];
int main() {
    while (scanf("%10s", a) == 1) {
        printf("%s\n", a);
    }
    return 0;
}