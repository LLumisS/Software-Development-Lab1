package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab1 {
    public double SumFunc() {
        Scanner scanner = new Scanner(System.in);

        double a, b, n, m;
        double result = 0;

        System.out.println("Values should be integer");
        while (true) {
            try {
                System.out.println("Enter the lower bounds: ");
                System.out.print("a = ");
                a = getValue(scanner.nextDouble());
                System.out.print("b = ");
                b = getValue(scanner.nextDouble());

                System.out.println("Enter the upper bounds: ");
                System.out.print("n = ");
                n = getValue(scanner.nextDouble());
                System.out.print("m = ");
                m = getValue(scanner.nextDouble());

                if(a > n || b > m)
                    throw new InputMismatchException();

                for (double i = a; i <= n; i++)
                    for (double j = b; j <= m; j++) {
                        if (i - 1 == 0)
                            throw new ArithmeticException();
                        result += i * j / (i - 1);
                    }

                break;
            } catch (InputMismatchException e) {
                System.err.println("Error: Input Mismatch.\n");
                scanner.nextLine();
            } catch (ArithmeticException e) {
                System.err.println("Error: Denominator turned zero.\n");
                scanner.nextLine();
            }
        }

        scanner.close();
        return result;
    }

    private double getValue(double input) throws InputMismatchException {
        if (input % 1 != 0)
            throw new InputMismatchException();
        return input;
    }
}
