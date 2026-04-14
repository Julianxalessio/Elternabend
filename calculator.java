import java.util.Scanner;

public class calculator {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // ANSI-Farben
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String CYAN = "\u001B[36m";
    public static final String PURPLE = "\u001B[35m";

    System.out.println(GREEN + "╔════════════════════════════╗");
    System.out.println(GREEN + "║     JAVA TASCHENRECHNER    ║");
    System.out.println(GREEN + "╚════════════════════════════╝");
    
    while (true) {
        System.out.println("Geben sie ihre Rechnung ein:");
        System.out.println("Erlaubt sind: +, -, *, /, und Zahlen auch mit Komma (z.B. 3.5)");
        System.out.print("Rechnung: ");
        if (!scanner.hasNextLine()) {
          System.out.println(CYAN + "\nKeine weitere Eingabe gefunden. Programm beendet.");
          break;
        }
        String input = scanner.nextLine();
        input = input.replace(",", ".");
        if (!input.matches("[0-9+\\-*/.]+")) {
            System.out.println(RED + "Ungültige Eingabe. Bitte nur Zahlen und Operatoren verwenden.");
        } else {
            String result = eval.calculate(input);
            System.out.println(CYAN + "Ergebnis: " + result);
          try {
            Thread.sleep(2000); // 2 Sekunden warten, damit der Benutzer das Ergebnis sehen kann
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println(RED + "Warten wurde unterbrochen.");
          }
            System.out.println();
            System.out.println();
        }
    }
      System.out.println(GREEN + "╔═══════════════════════════════╗");
      System.out.println(GREEN + "║     DANKE FUERS VERWENDEN!    ║");
      System.out.println(GREEN + "╚═══════════════════════════════╝");    
      scanner.close();
  }
}
