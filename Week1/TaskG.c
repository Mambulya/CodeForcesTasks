/*
ИХАБ И СТРАННЫЙ ЧЕЛОВЕК

Вам дан массив 𝑎 длины 𝑛. Вы можете выполнить следующую операцию с ним столько раз, сколько захотите:
Выберите любые два числа 𝑖 и 𝑗 (1≤𝑖,𝑗≤𝑛), такие что сумма 𝑎𝑖+𝑎𝑗 нечетная, и поменяйте местами 𝑎𝑖 и 𝑎𝑗.
Какой лексикографически минимальный массив вы можете получить?
Массив 𝑥 лексикографически меньше чем массив 𝑦, если есть такой индекс 𝑖, что 𝑥𝑖<𝑦𝑖, и 𝑥𝑗=𝑦𝑗 для всех 1≤𝑗<𝑖. Менее формально, в первой позиции 𝑖, которая отличается, 𝑥𝑖<𝑦𝑖.
*/

#include <stdio.h>
#include <stdlib.h>

int cmp(const void *a, const void *b) {
     return *(int*)a - *(int*)b;
}

int main()
{
    int n, flag = 0;
    scanf("%d", &n);
    int a[n];
    for (int i = 0; i < n; i++){
        scanf("%d", &a[i]);
    }
    int nechet = 0, chet = 0;
    for (int i = 0; i < n; i++){
        if (a[i] % 2 == 0) chet += 1;
        else nechet += 1;
        if (chet >= 1 && nechet >= 1){
            flag = 1;
            break;
        }
    }
    if (flag == 0){
        for (int i = 0; i < n-1; i++){
            printf("%d ", a[i]);
        }
        printf("%d", a[n-1]);
    } else {
        qsort(a, n, sizeof(int), cmp);
        for (int i = 0; i < n-1; i++){
            printf("%d ", a[i]);
        }
        printf("%d", a[n-1]);
    }
    return 0;
}
