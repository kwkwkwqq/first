import java.util.Scanner;

public class SafeCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] cells = new int[10];
        
        System.out.print("Ячейка 1 (1-10): ");
        int p1 = sc.nextInt() - 1;
        System.out.print("Кубик 1 (1-6): ");
        cells[p1] = sc.nextInt();
        
        System.out.print("Ячейка 2 (1-10): ");
        int p2 = sc.nextInt() - 1;
        System.out.print("Кубик 2 (1-6): ");
        cells[p2] = sc.nextInt();
        
        for (int i = 0; i <= 7; i++) {
            for (int a = 1; a <= 6; a++) {
                for (int b = 1; b <= 6; b++) {
                    for (int c = 1; c <= 6; c++) {
                        if (a + b + c == 10) {
                            if ((i == p1 && a == cells[p1]) || (i+1 == p1 && b == cells[p1]) || (i+2 == p1 && c == cells[p1])) {
                                if ((i == p2 && a == cells[p2]) || (i+1 == p2 && b == cells[p2]) || (i+2 == p2 && c == cells[p2])) {
                                    System.out.println("\nРешение: ячейки " + (i+1) + "," + (i+2) + "," + (i+3) + " = " + a + "," + b + "," + c);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println("\nРешения нет");
        sc.close();
    }
}