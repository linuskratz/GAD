import java.util.Scanner;

/**
 * Die Klasse BinSeaIO bildet die Schnittstelle zu TUMjudge. Sie erlaubt es,
 * die Eingabe einzulesen und eine passend formatierte Ausgabe zu erstellen.
 */
public class BinSeaIO {
  /**
   * Die Klasse Input kapselt die Eingabe, die das Programm von TUMjudge
   * erhält.
   */
  public static class Input {
    /**
     * Die Objektvariable sortedData enthält das sortierte Feld, in dem
     * der Wertebereich gesucht werden soll.
     */
    private int[] sortedData;

    public int[] getSortedData () {
      return sortedData;
    }

    /**
     * Die Objektvariable valueRange enthält den Wertebereich, nach dem
     * gesucht werden soll.
     */
    private Interval valueRange;

    public Interval getValueRange () {
      return valueRange;
    }

    public Input (int[] sortedData, int from, int to) {
      this.sortedData = sortedData;
      valueRange = new NonEmptyInterval(from, to);
    }
  }

  /**
   * Diese Methode liest die Eingabe ein und gibt sie verpackt in einem
   * Input-Objekt zurück. Die Eingabe umfasst eine Zeile und ist aufgebaut wie folgt:
   * 
   * [Größe g des sortierten Feldes] [Werte an Index 0 des sortierten Feldes] ... [Wert an
   * Index g - 1 des sortierten Feldes] [Beginn des gesuchten Wertebereiches] [Ende des
   * gesuchten Wertebereiches]
   * 
   * @return das Input-Objekt, welches die Eingabe enthält
   */
  public static Input readInput() {
    Scanner scanner = new Scanner(System.in);

    int sortedDataSize = scanner.nextInt();
    int[] sortedData = new int[sortedDataSize];
    for (int i = 0; i < sortedData.length; i++)
      sortedData[i] = scanner.nextInt();

    int from = scanner.nextInt();
    int to = scanner.nextInt();

    scanner.close();
    return new Input(sortedData, from, to);
  }

  /**
   * Diese Methode gibt das Ergebnis für den TUMjudge passend formatiert
   * aus. Die Ausgabe umfasst eine Zeile und ist aufgebaut wie folgt:
   * 
   * '['[Beginn des Indexbereiches];[Ende des Indexbreiches]']'
   * 
   * Ein leerer Bereich soll durch "[]" dargestellt werden.
   * 
   * Beispielausgabe für einen Indexbereich von 4 bis 42:
   * [4;42]
   * 
   * @param interval der auszugebende Wertebereich
   */
  public static void printOutput(Interval interval) {
    System.out.println(interval);
  }
}
