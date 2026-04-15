import java.util.Scanner;

public class calculator {
  public static void main(String[] args) throws InterruptedException {
    Scanner scanner = new Scanner(System.in);

    String input = null;
    String result = null;

    // ANSI-Farben
    final String RESET = "\u001B[0m";
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    final String CYAN = "\u001B[36m";

    System.out.println(GREEN + "╔════════════════════════════╗");
    System.out.println(GREEN + "║     JAVA TASCHENRECHNER    ║");
    System.out.println(GREEN + "╚════════════════════════════╝");

    db db = new db();
    
    while (true) {
        System.out.println(GREEN + "Geben sie ihre Rechnung ein:");
        System.out.println(GREEN + "Erlaubt sind: +, -, *, /, und Zahlen auch mit Komma (z.B. 3.5)");
        System.out.println(GREEN + "Geben sie 'old-inputs' ein um die letzten 10 Eingaben zu sehen.");
        System.out.print(GREEN + "Rechnung: ");
        if (!scanner.hasNextLine()) {
          System.out.println(CYAN + "\nKeine weitere Eingabe gefunden. Programm beendet.");
          break;
        }
        input = scanner.nextLine();
        input = input.replace(",", ".");
        if (input.equalsIgnoreCase("old-inputs")) {
          int i = 1;
          String[] old_inputs = db.download();
          System.out.println(CYAN + "Letzte 10 Eingaben:");
          if (old_inputs == null || old_inputs.length == 0) {
            System.out.println(CYAN + "Keine gespeicherten Eingaben gefunden.");
            System.out.println();
            Thread.sleep(1000);
            continue;
          }
          for (String old_input : old_inputs) {
            if (old_input != null) {
              System.out.println(CYAN + i + ". " + old_input);
              Thread.sleep(200); // 0.5 Sekunden warten, damit der Benutzer die Eingaben sehen kann
            }
            i++;
          }
          System.out.println();
          Thread.sleep(1000); // 1 Sekunde warten, damit der Benutzer die Eingaben sehen kann
          continue;
        }
        else if (!input.matches("[0-9+\\-*/.]+")) {
            System.out.println(RED + "Ungültige Eingabe. Bitte nur Zahlen und Operatoren verwenden die oben definiert wurden.");
            System.out.println();
            System.out.println();
        } else {
            result = eval.calculate(input);
            System.out.println(CYAN + "Ergebnis: " + result);    
            db.upload(input+ " = " + result);
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
