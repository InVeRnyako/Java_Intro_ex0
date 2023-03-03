// Задано уравнение вида q + w = e. q,w,e >= 0.
// Некоторые цифры могут быть заменены знакомы вопроса, например 2? + ?5 = 69
// Требуется восстановить выражение до верного равенства.
// Предложить хотя бы одно решение или сообщить, что его нет.

// День 2. Рекурсия не хочет вызывать все свои варианты

public class ex3 {
    public static void main(String[] args) {
        // String inputString = System.console().readLine();
        String inputString = "?? + 99 = 1000";
        String[] inputArray = inputString.split(" ");
        char[] charQ = inputArray[0].toCharArray();
        char[] charW = inputArray[2].toCharArray();
        char[] charE = inputArray[4].toCharArray();
        tryVariantsRedo(charQ, charW, charE);
        System.out.println("Подходящих решений нет.");
    }

    public static void checkProcess(char[] charQ, char[] charW, char[] charE) {
        System.out.print("charQ = \"");
        for (int i = 0; i < charQ.length; i++)
            System.out.print(charQ[i]);
        System.out.print("\" charW = \"");
        for (int i = 0; i < charW.length; i++)
            System.out.print(charW[i]);
        System.out.print("\" charE = \"");
        for (int i = 0; i < charE.length; i++)
            System.out.print(charE[i]);
        System.out.println();
    }

    public static char[] changeOnechar(char[] charArray, int index, char newValue) {
        charArray[index] = newValue;
        return charArray;
    }

    public static void tryVariantsRedo(char[] charQ, char[] charW, char[] charE) {
        for (int i = 0; i < charQ.length; i++) {
            if (charQ[i] == '?') {
                for (int j = 0; j < 10; j++) {
                    tryVariantsRedo(changeOnechar(charQ, i, (char) ('0' + j)), charW, charE);
                }
            }
        }
        checkWithChars(charQ, charW, charE);
    }

    public static void checkWithChars(char[] charQ, char[] charW, char[] charE) {
        // convert to numbers
        int numQ = 0;
        int numW = 0;
        int numE = 0;
        for (int i = 0; i < charQ.length; i++)
            numQ += Character.getNumericValue(charQ[i]) * Math.pow(10, charQ.length - (i + 1));
        for (int i = 0; i < charW.length; i++)
            numW += Character.getNumericValue(charW[i]) * Math.pow(10, charW.length - (i + 1));
        for (int i = 0; i < charE.length; i++)
            numE += Character.getNumericValue(charE[i]) * Math.pow(10, charE.length - (i + 1));
        // System.out.println("Проверка: " + numQ + " + " + numW + " = " + numE);
        if (numQ + numW == numE) {
            System.out.println(numQ + " + " + numW + " = " + numE);
            System.exit(0);
        }
    }

    // public static void tryVariants(char[] charQ, char[] charW, char[] charE) {
    // checkProcess(charQ, charW, charE);
    // for (int i = 0; i < charQ.length; i++) {
    // if (charQ[i] == '?') {
    // for (int j = 0; j < 10; j++) {
    // tryVariants(changeOnechar(charQ, i, (char) ('0' + j)), charW, charE);
    // }
    // }
    // }
    // for (int i = 0; i < charW.length; i++) {
    // for (int j = 0; charW[i] == '?' & j < 10; j++) {
    // tryVariants(charQ, changeOnechar(charW, i, (char) ('0' + j)), charE);
    // }
    // }
    // for (int i = 0; i < charE.length; i++) {
    // for (int j = 0; charE[i] == '?' & j < 10; j++) {
    // tryVariants(charQ, charW, changeOnechar(charE, i, (char) ('0' + j)));
    // }
    // }
    // checkWithChars(charQ, charW, charE);
    // }
}

// if (inputArray[0].replaceAll("\\d", "").length() == 0)
// numQ = Integer.parseInt(inputArray[0]);
// if (inputArray[2].replaceAll("\\d", "").length() == 0)
// numW = Integer.parseInt(inputArray[2]);
// if (inputArray[4].replaceAll("\\d", "").length() == 0)
// numQ = Integer.parseInt(inputArray[4]);