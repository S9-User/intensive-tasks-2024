package com.walking.intensive.chapter1.task1;

/**
 * Реализуйте метод getAgeString(), который будет принимать параметром целое число (возраст) и возвращать строку
 * вида: "Вам N лет". Программа должна учитывать правила русского языка.
 *
 * <p>Пример верного исполнения кода: "Вам 5 лет", "Вам 4 года".
 * Пример неверной работы программы: "Вам 14 года".
 *
 * <p>Также необходимо учесть негативные сценарии. Например, попытку передать в метод невалидное значение - например,
 * отрицательное число. В таких случаях ожидается, что метод вернет строку "Некорректный ввод".
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task1 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
        int age = 0;

        System.out.println(getAgeString(age));
    }

    static String getAgeString(int age) {

        int remainder = age%10;
        String output = "";

        if ((age < 0) || (age > 127)) {
            output = "Некорректный ввод";
        }

        if ((remainder == 0) || (age >= 5 && age <= 20) ||(age >= 105 && age <= 120) || (remainder >= 5 && remainder <= 9) ) {
            output ="Вам " + age + " лет";
        }

        if ((remainder == 1) & (age != 11) & (age != 111)) {
            output ="Вам " + age + " год";
        }

        if ( ((age > 20 && age < 105) || age<5 || age>120 )&&((remainder == 2) ^ (remainder == 3) ^ (remainder == 4))) {
            output ="Вам " + age + " года";
        }

        return output;




    }



}
