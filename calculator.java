import java.util.Scanner;

public class calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    while (true) {
        System.out.println("Geben sie ihre Rechnung ein:");
        System.out.println("Erlaubt sind: +, -, *, /, und Zahlen auch mit Komma (z.B. 3.5)");
        System.out.print("Rechnung: ");
        if (!scanner.hasNextLine()) {
          System.out.println("\nKeine weitere Eingabe gefunden. Programm beendet.");
          break;
        }
        String input = scanner.nextLine();
        input = input.replace(",", ".");
        if (!input.matches("[0-9+\\-*/.]+")) {
            System.out.println("Ungültige Eingabe. Bitte nur Zahlen und Operatoren verwenden.");
        } else {
            String result = eval.calculate(input);
            System.out.println("Ergebnis: " + result);
          try {
            Thread.sleep(2000); // 2 Sekunden warten, damit der Benutzer das Ergebnis sehen kann
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Warten wurde unterbrochen.");
          }
            System.out.println();
            System.out.println();
        }
    }
      scanner.close();
  }
}
