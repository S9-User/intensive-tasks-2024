package com.walking.intensive.chapter2.task7;

/**
 * Пятиклассник Ваня придумал забаву. Он ввел понятие «дружественной пары» чисел.
 * Два различных натуральных числа N и M он назвал дружественными, если сумма делителей числа N
 * (включая 1, но исключая само N) равна числу M и наоборот.
 *
 * <p>Например, 220 и 284 – дружественные числа:
 *
 * <ul>
 * <li>Список делителей для 220: 1, 2, 4, 5, 10, 11, 20, 22, 44, 55, 110. Их сумма равна 284;
 * <li>Список делителей для 284: 1, 2, 4, 71, 142. Их сумма равна 220.
 * </ul>
 *
 * <p>Реализуйте метод getFriendlyPair(), который принимает параметром число N,
 * где N - натуральное число не больше 1 000 000.
 *
 * <p>Метод должен вернуть наибольшее число из пары дружественных чисел,
 * сумма дружественных чисел которой максимальна среди всех пар дружественных
 * чисел, большее из которых меньше N.
 *
 * <p> Если входные данные некорректны - метод должен возвращать -1.
 *
 * <p>P.S. Решение не должно использовать массивы и прочие темы, которые пока не были затронуты в курсе.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task7 {
    public static void main(String[] args) {
        System.out.println(getFriendlyPair(15476));
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static int getFriendlyPair(int n) {
        if (n <= 2) {
            return -1;
        }

        int maxSum = 0;
        int result = -1;

        for (int i = 2; i < n; i++) {
            int sumOfDivisorsI = getSumOfDivisors(i);
            if (sumOfDivisorsI >= n || sumOfDivisorsI == i) continue;

            if (getSumOfDivisors(sumOfDivisorsI) == i) {
                int currentSum = i + sumOfDivisorsI;
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    result = Math.max(i, sumOfDivisorsI);
                }
            }
        }

        return result;
    }

    private static int getSumOfDivisors(int number) {
        int sum = 1; // Всегда считаем 1 как делитель

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                sum += i;
                int pairedDivisor = number / i;
                if (pairedDivisor != i) {
                    sum += pairedDivisor;
                }
            }
        }

        return sum;
    }
}
