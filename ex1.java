// Вывести все простые числа от 1 до 1000

public class ex1 {
    public static void main(String[] args) {
        int countLim = 1000;
        System.out.println("Простые числа от 1 до " + countLim + ":");
        System.out.print("2 ");
        boolean isPrime = true;
        for (int i = 3; i < countLim; i = i + 2) {
            for (int j = 3; j < i & isPrime ; j = j + 2) {
                if (i % j == 0) isPrime = false;
            }
            if (isPrime) System.out.print(i + " ");
            else isPrime = true;
        }
    }
}

