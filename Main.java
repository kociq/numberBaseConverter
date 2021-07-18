import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Enter number in decimal system:");
        Scanner scanner = new Scanner(System.in);
        int baseTenNumber = scanner.nextInt();
        System.out.println("Enter target base:");
        int targetBase = scanner.nextInt();
        System.out.println("Convertion result: " + convertToBase(baseTenNumber, targetBase));

    }
    
    public static String convertToBase(int baseTenNumber, int base) {
        String result = "";
        int remainder = 0;
        do {
            remainder = baseTenNumber % base;
            baseTenNumber /= base;
            switch (remainder) {
                case 10:
                    result = "A".concat(result);
                case 11:
                    result = "B".concat(result);
                case 12:
                    result = "C".concat(result);
                case 13:
                    result = "D".concat(result);
                case 14:
                    result = "E".concat(result);
                case 15:
                    result = "F".concat(result);
                default:
                    result = Integer.toString(remainder).concat(result);
            }
        } while (baseTenNumber > 0);

        return result;
    }

}
