import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        boolean back = false;
        int sourceBase = 0;
        int targetBase = 0;
        do {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            String scannedValues[] = scanner.nextLine().split(" ");
            if (scannedValues.length == 2) {
                sourceBase = Integer.valueOf(scannedValues[0]);
                targetBase = Integer.valueOf(scannedValues[1]);
                do {
                    System.out.println("Enter number in base " + sourceBase + " to convert to base " + targetBase + " (To go back type /back)");
                    String scannedValueOnSecondLevel = scanner.nextLine();

                    if (scannedValueOnSecondLevel.equals("/back")) {
                        break;
                    } else {
                        BigInteger resultAtBaseTen = convertBaseAnyToTen(scannedValueOnSecondLevel, sourceBase);
                        String resultFinal = convertBaseTenToAny(resultAtBaseTen, targetBase);
                        System.out.println("Conversion result: " + resultFinal);
                    }

                } while (!back);
            } else {
                break;
            }

        } while (!exit);
    }

    public static String convertBaseTenToAny(BigInteger baseTenNumber, int base) {
        String result = "";
        BigInteger remainder = BigInteger.ZERO;
        do {
            remainder = baseTenNumber.remainder(BigInteger.valueOf(base));
            baseTenNumber = baseTenNumber.divide(BigInteger.valueOf(base));
            if (remainder.compareTo(BigInteger.TEN) >= 0) {
                result = Character.toString(remainder.intValue() + 87).concat(result);
            } else {
                result = remainder.toString().concat(result);
            }

        } while (baseTenNumber.compareTo(BigInteger.ZERO) > 0);

        return result;
    }

    public static BigInteger convertBaseAnyToTen(String anyBaseNumber, int base) {
        return new BigInteger(anyBaseNumber, base);
    }

}
