import java.util.Arrays;

import javax.swing.JPopupMenu.Separator;

// Задано уравнение вида q + w = e. q,w,e >= 0.
// Некоторые цифры могут быть заменены знакомы вопроса, например 2? + ?5 = 69
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.

// День 2. Рекурсия не хочет вызывать все свои варианты
// День 3. Код без рекурсии. Общий план - объеденить все переменные в одну строку.

public class ex3 {
    public static void main(String[] args) {
        String inputString = System.console().readLine();
        // String inputString = "?? + 10 = 102";
        String[] inputArray = inputString.split(" ");
        for (int i = 0; i < inputArray.length; i = i + 2) {
            for (int j = 0; j < inputArray[i].length(); j++) {
                if (inputArray[i].charAt(j) == '?') {
                    for (int j2 = 0; j2 < 10; j2++) {
                        inputArray[i] = putNumberInSting(inputArray[i], j, j2);
                        checkResult(inputArray);
                    }
                }
            }
        }
        System.out.println("Подходящих решений нет.");
    }

    public static String putNumberInSting(String inString, int idOfChar, int newValue) {
        char[] chars = inString.toCharArray();
        chars[idOfChar] = (char)(newValue + '0');
        return String.valueOf(chars);
    }

    public static void checkResult(String[] arrayToCheck) {
        System.out.println("Progress: " + String.join("", arrayToCheck));
        boolean onlyNumbers = true;
        for (String i : arrayToCheck)
            if (i.indexOf('?') != -1)
                onlyNumbers = false;
        if (onlyNumbers)
            if (Integer.parseInt(arrayToCheck[0]) + Integer.parseInt(arrayToCheck[2]) == Integer
                    .parseInt(arrayToCheck[4])) {
                System.out.println(String.join("", arrayToCheck));
                System.exit(0);
            }
    }
}
