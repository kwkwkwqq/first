import java.util.Scanner;

public class NumberTransformer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите трёхзначное число: ");
        int number = scanner.nextInt();
        
        boolean isEven = (number % 2 == 0);
        
        int hundreds = number / 100;
        int tens = (number / 10) % 10;
        int units = number % 10;
        
        if (isEven) {
            hundreds = transformDigitEven(hundreds);
            tens = transformDigitEven(tens);
            units = transformDigitEven(units);
        } else {
            hundreds = transformDigitOdd(hundreds);
            tens = transformDigitOdd(tens);
            units = transformDigitOdd(units);
        }
        
        int newNumber = hundreds * 100 + tens * 10 + units;
        System.out.println("Новое число: " + newNumber);
        
        scanner.close();
    }
    
    private static int transformDigitEven(int digit) {
        if (digit % 2 == 0) {
            if (digit + 1 <= 9) return digit + 1;
        } else {
            if (digit - 1 >= 0) return digit - 1;
        }
        return digit;
    }
    
    private static int transformDigitOdd(int digit) {
        if (digit % 2 == 0) {
            if (digit - 1 >= 0) return digit - 1;
        } else {
            if (digit + 1 <= 9) return digit + 1;
        }
        return digit;
    }
}