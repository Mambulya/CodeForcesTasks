/*
МЕНЬШИЕ ИЛИ РАВНЫЕ


Вам задана последовательность длины 𝑛 целых чисел и целое число 𝑘. Ваша задача состоит в том, чтобы вывести любое целое число 𝑥 из отрезка [1;109] (то есть 1≤𝑥≤109) такое, что ровно 𝑘 элементов заданной последовательности меньше либо равны 𝑥.
Заметьте, что последовательность может содержать равные элементы.
Если искомого 𝑥 не существует, выведите «-1» (без кавычек).

Пример:
7 4
3 7 5 1 10 3 20
Ответ: 6
*/
import java.util.Scanner;
import java.util.Arrays;

public class Task1C {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        long x = -1;

        if (n <= 0 | k < 0) System.out.println(-1);
        else {
            int[] numbers = new int[n];

            for (int i = 0; i < n; i++) {
                numbers[i] = input.nextInt();
            }

            Arrays.sort(numbers);
            // if (numbers[0] != 1 && k == 0) x = numbers[0];
            if (k == 0) {
                if (numbers[0] != 1) x = 1;
            } else {
                if (k == n) x = numbers[n-1];
                if (k < n) {
                    if (isUniq(numbers) && numbers[k-1] != numbers[k]) x = numbers[0];
                    else {
                        if (numbers[k-1] != numbers[k]) x = numbers[k-1];
                    }
                }

            }
            if ((1 <= x ) && ( x <= 1000000000)) System.out.println(x);
            else System.out.println(-1);
        }
    }

    public static boolean isUniq(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1]) return false;
        }
        return true;
    }
}
