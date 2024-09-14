/*
Отсортированные разности соседних
У вас есть массив из 𝑛 чисел 𝑎1,𝑎2,…,𝑎𝑛.
Переставьте эти числа так, чтобы они удовлетворяли |𝑎1−𝑎2|≤|𝑎2−𝑎3|≤…≤|𝑎𝑛−1−𝑎𝑛|, где |𝑥| обозначает абсолютное значение 𝑥. Гарантируется, что для данных ограничений всегда можно найти такую перестановку.
Обратите внимание, что элементы в 𝑎 не обязательно попарно различны. Другими словами, некоторые элементы 𝑎 могут быть одинаковыми.
Вы должны ответить на 𝑡 независимых тестовых случаев.

ПРИМЕР:
2
6
5 -2 4 8 6 5
4
8 1 4 2

ОТВЕТ:
5 5 4 6 8 -2
1 2 4 8
*/

import java.util.Scanner;
import java.util.Arrays;

public class Task1E {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int n;
        for (int t0 = 0; t0 < t; t0++) {
            n = in.nextInt();

            long[] numbers = new long[n];
            long[] diff = new long[n];
            int j = n-1;

            for (int i = 0; i < n; i++) {
                numbers[i] = in.nextLong();
            }

            Arrays.sort(numbers);

            for (int i = n - 2; i >= 0; i = i - 2) {
                diff[i] = numbers[j];
                j--;
            }
            j = 0;
            for (int i = n - 1; i >= 0; i = i - 2) {
                diff[i] = numbers[j];
                j++;
            }

            printArr(diff);
            System.out.print("\n");

        }
    }

    public static void printArr(long[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i != arr.length - 1) System.out.print(" ");
        }
    }
}
