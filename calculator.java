import java.util.Scanner;

public class calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // ANSI-Farben
    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String CYAN = "\u001B[36m";

    System.out.println(GREEN + "╔════════════════════════════╗");
    System.out.println(GREEN + "║     JAVA TASCHENRECHNER    ║");
    System.out.println(GREEN + "╚════════════════════════════╝");
    
    while (true) {
        System.out.println(GREEN + "Geben sie ihre Rechnung ein:");
        System.out.println(GREEN + "Erlaubt sind: +, -, *, /, und Zahlen auch mit Komma (z.B. 3.5)");
        System.out.print(GREEN + "Rechnung: ");
        if (!scanner.hasNextLine()) {
          System.out.println(CYAN + "\nKeine weitere Eingabe gefunden. Programm beendet.");
          break;
        }
        String input = scanner.nextLine();
        input = input.replace(",", ".");
        if (!input.matches("[0-9+\\-*/.]+")) {
            System.out.println(RED + "Ungültige Eingabe. Bitte nur Zahlen und Operatoren verwenden die oben definiert wurden.");
            System.out.println();
            System.out.println();
        } else {
            String result = eval.calculate(input);
            System.out.println(CYAN + "Ergebnis: " + result);
          try {
            Thread.sleep(1000); // 1 Sekunde warten, damit der Benutzer das Ergebnis sehen kann
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(RED + "Warten wurde unterbrochen.");
          }
            System.out.println();
            System.out.println();
        }
    }
    System.out.println(RESET);
    scanner.close();
  }
}
