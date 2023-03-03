// Реализовать простой калькулятор
import java.lang.System;

public class ex2 {
    public static void main(String[] args) {
        System.out.println(
                "Введите математическое выражение без пробелов." + 
                "Поддерживаются знаки: [ + - * / ], порядок действий игнорируется.");
        String inputStr = System.console().readLine();

        String[] inputSplit = inputStr.split("\\D");
        int[] arguments = new int[inputSplit.length];
        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = Integer.parseInt(inputSplit[i]);
        }

        String operators = inputStr.replaceAll("\\d", "");

        double result = arguments[0];
        for (int i = 1; i < arguments.length; i++) {
            if (operators.charAt(i - 1) == '+') {
                result += arguments[i];
            } else {
                if (operators.charAt(i - 1) == '-') {
                    result -= arguments[i];
                } else {
                    if (operators.charAt(i - 1) == '*') {
                        result *= arguments[i];
                    } else {
                        if (operators.charAt(i - 1) == '/') {
                            result /= arguments[i];
                        } else {
                            System.out.println("Ошибка ввода.");
                            java.lang.System.exit(0);
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
