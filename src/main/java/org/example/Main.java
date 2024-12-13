package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите значение x: ");

        double x = scanner.nextDouble();

        double y = calculateFunctionValue(x);

        System.out.println("Значение функции y в точке x = " + x + " равно " + y);

        boolean isInUpperHalfCircle = checkInUpperHalfCircle(x, y);


        System.out.println("Результат функции y(x): " + y);
        System.out.println("Входит ли точка (x, y) в верхний полукруг с центром в начале координат и радиусом 5: " + isInUpperHalfCircle);
    }

    public static double calculateFunctionValue(double x) {
        double y = Math.asin(Math.sqrt(Math.abs(x)) / (Math.sqrt(Math.abs(x)) + 1));
        y = Math.pow(y, 5);
        y += Math.pow((x * x + 1), 0.2);

        double w = Math.sin(x);
        double v = Math.abs(x);
        double u = Math.cos(x);

        double logPart = Math.log(Math.pow(2, w) + Math.pow(v, u)) / Math.log(2);

        y += logPart;

        return y;
    }

    public static boolean checkInUpperHalfCircle(double x, double y) {
        return ((y >= 0)) && ((Math.pow(x, 2) + Math.pow(y, 2) <= 25));
    }
}