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
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    static boolean isPalindrome(String inputString) {

        if (inputString == null || inputString.length() < 2) {
            return false;
        }

        StringBuilder cleanedStrBuilder = new StringBuilder();

        for (char c : inputString.toCharArray()) {
            if (Character.isLetter(c)) {
                cleanedStrBuilder.append(Character.toLowerCase(c));
            }
        }

        String cleanedStr = cleanedStrBuilder.toString();

        int left = 0;
        int right = cleanedStr.length() - 1;

        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
}
