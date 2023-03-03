// Вычислить n-ое треугольного(?) число (Сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

public class ex0 {
    public static void main(String[] args) {
        System.out.print("Введите число n: ");
        int n = Integer.parseInt(System.console().readLine());
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += n;
        }
        System.out.println("Сумма чисел от 1 до " + n + ": " + sum);
    }
    
}