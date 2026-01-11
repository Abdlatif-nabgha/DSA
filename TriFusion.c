#include<stdio.h>
#include <stdlib.h>

// complexite pour cet fonction = O(n/2)
void diviser(int *t, int *t1, int *t2, int n) {
    int j = 0, i = 0, m = n / 2;
    for (; i < m; i++) t1[i] = t[i];
    for (; i < n; i++, j++) t2[j] = t[i];
}

// complexite pour cet fonction = O(n)
void fusionner(int *t, int *t1, int *t2, int n) {
    int i = 0, j = 0, k = 0, m1 = n / 2, m2 = n - m1;

    while (i < m1 && j < m2) t[k++] = t1[i] < t2[j] ? t1[i++] : t2[j++];
    for (; i < m1; i++) t[k++] = t1[i];
    for (; j < m2; j++) t[k++] = t2[j];
}

void triFusion(int *t, int n) {
    if (n > 1) {
        int m1 = n / 2, m2 = n - m1, *t1 = malloc(m1 * sizeof(int)), *t2 = malloc(sizeof(int) * m2);
        diviser(t, t1, t2, n);
        triFusion(t1, m1);
        triFusion(t2, m2);
        fusionner(t, t1, t2, n);
        free(t1);
        free(t2);
    }
}

int main() {
    int t[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    triFusion(t, 10);
    for (int i = 0; i < 10; i++) printf("%d ", t[i]);
    return 0;
}
