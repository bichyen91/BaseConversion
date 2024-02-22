package baseconversion;

import java.util.Scanner;

public class BaseConversion {

    public static String convertDecBase(int number, int base) {
        int remainder = 0;
        StringBuilder sb = new StringBuilder();
        int temp = number;
        while (temp != 0) {
            remainder = temp % base;
            temp = temp / base;
            if (base == 16) {
                switch (remainder) {
                    case 10 ->
                        sb.append("A");
                    case 11 ->
                        sb.append("B");
                    case 12 ->
                        sb.append("C");
                    case 13 ->
                        sb.append("D");
                    case 14 ->
                        sb.append("E");
                    case 15 ->
                        sb.append("F");
                    default ->
                        sb.append(remainder);
                }
            } else {
                sb.append(remainder);
            }
        }
        return base == 16 ? "0x" + sb.reverse().toString()
                : sb.reverse().toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String isEsc;
        do {
            System.out.println("Press any key to continues, ESC to exit.");
            isEsc = input.next();
            if (!"ESC".equalsIgnoreCase(isEsc)) {
                System.out.print("Input number: ");
                int num = input.nextInt();
                do {
                    if (num < 0) {
                        System.out.println("No negative number please!!!");
                        System.out.print("Input number: ");
                        num = input.nextInt();
                    }
                } while (num < 0);
                System.out.print("Input base: ");
                int base = input.nextInt();
                do {
                    if (base < 2 || base > 16) {
                        System.out.println("Base from 2 to 16");
                        System.out.print("Input base: ");
                        base = input.nextInt();
                    }
                } while (base < 2 || base > 16);
                System.out.println("The equivalent base-" + base
                        + " value of decimal " + num + " is: "
                        + convertDecBase(num, base));
                System.out.println();
            }
        } while (!"ESC".equalsIgnoreCase(isEsc));
    }
}
