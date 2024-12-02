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
    static double getPerymeter(double a, double b, double c) {
        return (a + b + c) / 2;
    }

    static boolean isValid(double a, double b, double c) {
        return a > 0 & b > 0 & c > 0 &
                a + b > c & a + c > b & b + c > a;
    }

    static double getAreaByHeron(double a, double b, double c) {
        double p = getPerymeter(a, b, c);

        if (!isValid(a, b, c)) {
            return -1;
        }

        return sqrt(p * (p - a) * (p - b) * (p - c));
    }

    /**
     * Реализуйте метод, который будет возвращать высоты треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с высотами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getHeights(double a, double b, double c) {

        if (!isValid(a, b, c)) {
            return new double[0];
        }

        double S = getAreaByHeron(a, b, c);
        double ha = (2 * S) / a;
        double hb = (2 * S) / b;
        double hc = (2 * S) / c;
        double[] Heights = new double[3];
        Heights[0] = Math.min(Math.min(ha, hb), hc);
        Heights[2] = Math.max(Math.max(ha, hb), hc);
        if (ha > Heights[0] && ha < Heights[2]) {
            Heights[1] = ha;
        } else {
            if (hb > Heights[0] && hb < Heights[2]) {
                Heights[1] = hb;
            } else {
                Heights[1] = hc;
            }
        }
        return Heights;
    }

    /**
     * Реализуйте метод, который будет возвращать медианы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с медианами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getMedians(double a, double b, double c) {
        if (!isValid(a, b, c)) {
            return new double[0];
        }

        double m_a = 0.5 * Math.sqrt(2 * b * b + 2 * c * c - a * a);
        double m_b = 0.5 * Math.sqrt(2 * a * a + 2 * c * c - b * b);
        double m_c = 0.5 * Math.sqrt(2 * a * a + 2 * b * b - c * c);
        double[] Medians = new double[3];
        Medians[0] = Math.min(Math.min(m_a, m_b), m_c);
        Medians[2] = Math.max(Math.max(m_a, m_b), m_c);
        if (m_a > Medians[0] && m_a < Medians[2]) {
            Medians[1] = m_a;
        } else {
            if (m_b > Medians[0] && m_b < Medians[2]) {
                Medians[1] = m_b;
            } else {
                Medians[1] = m_c;
            }
        }
        return Medians;
    }

    /**
     * Реализуйте метод, который будет возвращать биссектрисы треугольника по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с биссектрисами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getBisectors(double a, double b, double c) {
        if (!isValid(a, b, c)) {
            return new double[0];
        }

        double bisA = Math.sqrt(b * c * (1 - Math.pow(a, 2) / Math.pow(b + c, 2)));
        double bisB = Math.sqrt(a * c * (1 - Math.pow(b, 2) / Math.pow(a + c, 2)));
        double bisC = Math.sqrt(a * b * (1 - Math.pow(c, 2) / Math.pow(a + b, 2)));
        double[] Bisectors = new double[3];
        Bisectors[0] = Math.min(Math.min(bisA, bisB), bisC);
        Bisectors[2] = Math.max(Math.max(bisA, bisB), bisC);
        if (bisA > Bisectors[0] && bisA < Bisectors[2]) {
            Bisectors[1] = bisA;
        } else {
            if (bisB > Bisectors[0] && bisB < Bisectors[2]) {
                Bisectors[1] = bisB;
            } else {
                Bisectors[1] = bisC;
            }
        }
        return Bisectors;
    }

    /**
     * Реализуйте метод, который будет возвращать углы треугольника (в градусах) по возрастанию.
     *
     * <p>Входные параметры - длина сторон треугольника. Возвращаемое значение - массив с углами треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать пустой массив нулевой длины.
     */
    static double[] getAngles(double a, double b, double c) {
        if (!isValid(a, b, c)) {
            return new double[0];
        }

        double cosA = (b * b + c * c - a * a) / (2 * b * c);
        double cosB = (a * a + c * c - b * b) / (2 * a * c);
        double cosC = (a * a + b * b - c * c) / (2 * a * b);

        double angleA = Math.toDegrees(Math.acos(cosA));
        double angleB = Math.toDegrees(Math.acos(cosB));
        double angleC = Math.toDegrees(Math.acos(cosC));

        double[] Angles = new double[3];
        Angles[0] = Math.min(Math.min(angleA, angleB), angleC);
        Angles[2] = Math.max(Math.max(angleA, angleB), angleC);
        if (angleA > Angles[0] && angleA < Angles[2]) {
            Angles[1] = angleA;
        } else {
            if (angleB > Angles[0] && angleB < Angles[2]) {
                Angles[1] = angleB;
            } else {
                Angles[1] = angleC;
            }
        }
        return Angles;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса вписанной в треугольник окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getInscribedCircleRadius(double a, double b, double c) {
        if (!isValid(a, b, c)) {
            return -1;
            }

        double p = getPerymeter(a, b, c);
        return getAreaByHeron(a, b, c) / p;
    }

    /**
     * Реализуйте метод, который будет возвращать длину радиуса описанной вокруг треугольника окружности.
     *
     * <p>Входные параметры - длина сторон треугольника.
     *
     * <p>Если входные данные некорректны - метод должен возвращать -1.
     */
    static double getCircumradius(double a, double b, double c) {
        if (!isValid(a, b, c)) {
            return -1;
        }

        return (a * b * c) / (4 * getAreaByHeron(a, b, c));
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
        if (!isValid(a, b, c)) {
            return -1;
        }

        double cosC = (a * a + b * b - c * c) / (2 * a * b);
        double sinC = Math.sqrt(1 - cosC * cosC);
        return 0.5 * a * b * sinC;
    }
}
