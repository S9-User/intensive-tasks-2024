package com.walking.intensive.chapter1.task5;

import static java.lang.Math.sqrt;

/**
 * Задача поиска площади, величин углов, длин высот, биссектрис, медиан, радиусов вписанной и описанной вокруг
 * треугольника окружностей является центральной в Геометрии.
 *
 * <p>Реализуйте представленные ниже методы в соответствии с заданными условиями.
 *
 * <p><a href="https://github.com/KFalcon2022/intensive-tasks-2024/blob/master/README.md">Требования к оформлению</a>
 */
public class Task5 {
    public static void main(String[] args) {
//        Для собственных проверок можете делать любые изменения в этом методе
    }

    /**
     * Частным случаем Tеоремы Брахмагупты является формула Герона.
     *
     * <p>Реализуйте метод поиска площади треугольника формулой Герона.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - площадь треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaByHeron(double a, double b, double c) {
        double p = (a + b + c) / 2;

        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {

            return sqrt(p * (p - a) * (p - b) * (p - c));
        }

        return -1;
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {

            double S = getAreaByHeron(a, b, c);
            double ha = (2 * S) / a;
            double hb = (2 * S) / b;
            double hc = (2 * S) / c;
            double[] ascendingHeights = new double[3];
            ascendingHeights[0] = Math.min(Math.min(ha, hb), hc);
            ascendingHeights[2] = Math.max(Math.max(ha, hb), hc);
            if (ha > ascendingHeights[0] && ha < ascendingHeights[2]) {
                ascendingHeights[1] = ha;
            } else {
                if (hb > ascendingHeights[0] && hb < ascendingHeights[2]) {
                    ascendingHeights[1] = hb;
                } else {
                    ascendingHeights[1] = hc;
                }
            }
            return ascendingHeights;
        }
        return new double[0]; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {
            double m_a = 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
            double m_b = 0.5 * Math.sqrt(2 * a * a + 2 * c * c - b * b);
            double m_c = 0.5 * Math.sqrt(2 * a * a + 2 * b * b - c * c);
            double[] ascendingMedians = new double[3];
            ascendingMedians[0] = Math.min(Math.min(m_a, m_b), m_c);
            ascendingMedians[2] = Math.max(Math.max(m_a, m_b), m_c);
            if (m_a > ascendingMedians[0] && m_a < ascendingMedians[2]) {
                ascendingMedians[1] = m_a;
            } else {
                if (m_b > ascendingMedians[0] && m_b < ascendingMedians[2]) {
                    ascendingMedians[1] = m_b;
                } else {
                    ascendingMedians[1] = m_c;
                }
            }
            return ascendingMedians;
        }
        return new double[0]; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {
            double bisA = Math.sqrt(b * c * (1 - Math.pow(a, 2) / Math.pow(b + c, 2)));
            double bisB = Math.sqrt(a * c * (1 - Math.pow(b, 2) / Math.pow(a + c, 2)));
            double bisC = Math.sqrt(a * b * (1 - Math.pow(c, 2) / Math.pow(a + b, 2)));
            double[] ascendingBisectors = new double[3];
            ascendingBisectors[0] = Math.min(Math.min(bisA, bisB), bisC);
            ascendingBisectors[2] = Math.max(Math.max(bisA, bisB), bisC);
            if (bisA > ascendingBisectors[0] && bisA < ascendingBisectors[2]) {
                ascendingBisectors[1] = bisA;
            } else {
                if (bisB > ascendingBisectors[0] && bisB < ascendingBisectors[2]) {
                    ascendingBisectors[1] = bisB;
                } else {
                    ascendingBisectors[1] = bisC;
                }
            }
            return ascendingBisectors;
        }
        return new double[0]; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {
            double cosA = (b * b + c * c - a * a) / (2 * b * c);
            double cosB = (a * a + c * c - b * b) / (2 * a * c);
            double cosC = (a * a + b * b - c * c) / (2 * a * b);

            double angleA = Math.toDegrees(Math.acos(cosA));
            double angleB = Math.toDegrees(Math.acos(cosB));
            double angleC = Math.toDegrees(Math.acos(cosC));

            double[] ascendingAngles = new double[3];
            ascendingAngles[0] = Math.min(Math.min(angleA, angleB), angleC);
            ascendingAngles[2] = Math.max(Math.max(angleA, angleB), angleC);
            if (angleA > ascendingAngles[0] && angleA < ascendingAngles[2]) {
                ascendingAngles[1] = angleA;
            } else {
                if (angleB > ascendingAngles[0] && angleB < ascendingAngles[2]) {
                    ascendingAngles[1] = angleB;
                } else {
                    ascendingAngles[1] = angleC;
                }
            }
            return ascendingAngles;
        }
        return new double[0]; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {
            double p = (a + b + c) / 2;
            return getAreaByHeron(a, b, c) / p;

        }

        return -1; // Заглушка. При реализации - удалить
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {
            return (a * b * c) / (4 * getAreaByHeron(a, b, c));
        }
        return -1; // Заглушка. При реализации - удалить
    }

    /**
     * Дополнительная задача по желанию.
     *
     * <p>Реализуйте метод, который будет возвращать площадь треугольника.
     *
     * <p>Расчет площади должен быть произведем через поиск косинуса угла через теорему косинусов,
     * далее нахождение синуса через основное тригонометрическое тождество
     * и подстановку синуса в нужную формулу для площади треугольника.
     * (Всего основных способов поиска площади треугольника 6)
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getAreaAdvanced(double a, double b, double c) {
        if ((a + b > c && a + c > b && b + c > a) &&
                a > 0 && b > 0 && c > 0) {
            double cosC = (a * a + b * b - c * c) / (2 * a * b);

            double sinC = Math.sqrt(1 - cosC * cosC);

            return 0.5 * a * b * sinC;
        }

        return -1; // Заглушка. При реализации - удалить
    }
}
