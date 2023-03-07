import java.util.Scanner;

// Вычислить n-ое треугольного(?) число (Сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

public class ex0 {
    public static void main(String[] args) {
        System.out.println("Вычисление n-го треугольного числа и n!.");
        System.out.print("Введите число n: ");
        int n = 0;
        boolean numNotValid = true;
        while (numNotValid) {
            n = getIntFromUser();
            if (n > 0) numNotValid = false;
        }
        int sum = 0;
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            sum += n;
            factorial *= n;
        }
        System.out.println("Сумма чисел от 1 до " + n + ": " + sum);
        System.out.println("n! = " + factorial);
    }

    public static Integer getIntFromUser() {
        String inputString = "";
        int inputInt = 0;
        Scanner sc = new Scanner(System.in);
        inputString = sc.nextLine();
        sc.close();
        try{
            inputInt = Integer.parseInt(inputString);
        }catch (NumberFormatException e) {
            System.out.println("Ошибка ввода данных: " + e);
            return 0;
        }
        return inputInt;
    }
}