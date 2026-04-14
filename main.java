import java.util.Scanner;

public class calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Bitte erste Zahl eingeben: ");
    double zahl1 = scanner.nextDouble();

    System.out.print("Operator eingeben (+, -, *, /): ");
    char operator = scanner.next().charAt(0);

    System.out.println("Bitte zweite Zahl eingeben: ");
    double zahl2 = scanner.nextDouble();

    double ergebnis;

    switch (operator) {
            case '+':
                ergebnis = zahl1 + zahl2;
                System.out.println("Ergebnis: " + ergebnis);
                break;
            case '-':
                ergebnis = zahl1 - zahl2;
                System.out.println("Ergebnis: " + ergebnis);
                break;
            case '*':
                ergebnis = zahl1 * zahl2;
                System.out.println("Ergebnis: " + ergebnis);
                break;
            case '/':
                if (zahl2 != 0) {
                    ergebnis = zahl1 / zahl2;
                    System.out.println("Ergebnis: " + ergebnis);
                } else {
                    System.out.println("Fehler: Division durch 0 ist nicht erlaubt.");
                }
                break;
            default:
                System.out.println("Ungültiger Operator.");
        }

        scanner.close();
  }
}
