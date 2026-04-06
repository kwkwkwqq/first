import java.util.ArrayList;
import java.util.Scanner;

public class PairSumInput {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Введите числа через пробел:");
        String[] input = sc.nextLine().split(" ");
        
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        
        System.out.println("\nИсходный ряд: " + numbers);
        System.out.println();
        
        int stage = 1;
        
        while (numbers.size() > 1) {
            ArrayList<Integer> newNumbers = new ArrayList<>();
            
            for (int i = 0; i < numbers.size() - 1; i += 2) {
                newNumbers.add(numbers.get(i) + numbers.get(i + 1));
            }
            
            if (numbers.size() % 2 != 0) {
                newNumbers.add(numbers.get(numbers.size() - 1));
            }
            
            System.out.println("Этап " + stage + ": " + numbers + " -> " + newNumbers);
            numbers = newNumbers;
            stage++;
        }
        
        System.out.println("\nИтоговое число: " + numbers.get(0));
        sc.close();
    }
}