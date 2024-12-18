package com.walking.intensive.chapter2.task10;

/**
 * Реализуйте метод isPalindrome(), который проверяет, является ли строка палиндромом.
 *
 * <p>Метод должен игнорировать пунктуацию, пробелы и регистр.
 *
 * <p>P.S. Мой любимый палиндром: Муза! Ранясь шилом опыта, ты помолишься на разум.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task10 {
    public static void main(String[] args) {
        System.out.println(isPalindrome("А роза упала на лапу Азора"));
    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.length() < 2) {
            return false;
        }
        int left = 0;
        int right = inputString.length() - 1;

        while (left < right) {
            // Пропускаем небуквенные символы слева
            while (left < right && !Character.isLetter(inputString.charAt(left))) {
                left++;
            }
            // Пропускаем небуквенные символы справа
            while (left < right && !Character.isLetter(inputString.charAt(right))) {
                right--;
            }

            // Сравниваем буквы, приведённые к нижнему регистру
            if (Character.toLowerCase(inputString.charAt(left)) != Character.toLowerCase(inputString.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}