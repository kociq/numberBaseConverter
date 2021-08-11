import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;
        do {
            System.out.println("Do you want to convert /from decimal or /to decimal? (To quit type /exit)");
            Scanner scanner = new Scanner(System.in);
            String move = scanner.nextLine();
            switch (move) {
                case "/from":
                    System.out.println("Enter a number in decimal system:");
                    int baseTenNumber = scanner.nextInt();
                    System.out.println("Enter target base:");
                    int targetBase = scanner.nextInt();
                    System.out.println("Conversion result: " + convertBaseTenToAny(baseTenNumber, targetBase));
                    break;
                case "/to":
                    System.out.println("Enter source number:");
                    String anyBaseNumber = scanner.nextLine();
                    System.out.println("Enter source base:");
                    int sourceBase = scanner.nextInt();
                    System.out.println("Conversion to decimal result: " + convertBaseAnyToTen(anyBaseNumber, sourceBase));
                    break;
                case "/exit":
                    exit = true;
                    break;
            }
        } while (!exit);
    }
    
    public static String convertBaseTenToAny(int baseTenNumber, int base) {
        String result = "";
        int remainder = 0;
        do {
            remainder = baseTenNumber % base;
            baseTenNumber /= base;
            switch (remainder) {
                case 10:
                    result = "a".concat(result);
                    break;
                case 11:
                    result = "b".concat(result);
                    break;
                case 12:
                    result = "c".concat(result);
                    break;
                case 13:
                    result = "d".concat(result);
                    break;
                case 14:
                    result = "e".concat(result);
                    break;
                case 15:
                    result = "f".concat(result);
                    break;
                default:
                    result = Integer.toString(remainder).concat(result);
            }
        } while (baseTenNumber > 0);

        return result;
    }

    public static int convertBaseAnyToTen(String anyBaseNumber, int base) {
        return Integer.parseInt(anyBaseNumber, base);

    }

}
