import java.awt.GraphicsEnvironment;
import java.util.Random;
import java.util.Scanner;

/**
 * Program Klasse darf nicht erweitert oder verändert werden, außer explizit
 * angegeben!
 */
public class Program {
    // Initialisierung des Testarrays, darf abgeändert werden
    public final static int SEED = 0;
    public final static int N = 10;
    public final static int MAX_V = 100;

    // Ausgabe der Zwischenergebnisse, darf abgeändert werden
    public final static boolean VERBOSE = true;

    /**
     * Folgender Code darf nicht geändert werden!
     */

    //--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------

    // Wird bei Ausführung in TUMJudge automatisch auf "true" gesetzt. Falls "true" keine zusätzliche Ausgaben ausgeben!
    public final static boolean TUMJUDGE = GraphicsEnvironment.isHeadless();

    // "main"-Funktion nicht ändern!
    public static void main(String[] args) {
        BinomialHeap bh = new BinomialHeap();
        int n = 0;
        if (TUMJUDGE) {
            Scanner scanner = new Scanner(new Scanner(System.in).nextLine());
            while (scanner.hasNextInt()) {
                bh.insert(scanner.nextInt());
                bh.printTree();
                n++;
            }
			scanner.close();
        } else {
            Random r = new Random(SEED);
            n = N;
            for (int i = 0; i < N; i++) {
                bh.insert(r.nextInt(MAX_V));
                if (VERBOSE) {
                    bh.printTree();
                }
            }
        }

        int[] sortedArray = new int[n];
        for(int i = 0; i < n; i++) {
            if (VERBOSE || TUMJUDGE) {
                bh.printTree();
            }
            sortedArray[i] = bh.deleteMin();
        }
        System.out.print("Result:\n\t");
        printArray(sortedArray);
        checkSorting(sortedArray);
    }

    public static void printArray(int[] numbers) {
        int displayCount = numbers.length;
        String ext = "";
        if (numbers.length > 15) {
            displayCount = 15;
            ext = "...";
        }
        for (int i = 0; i < displayCount - 1; i++) {
            System.out.print(numbers[i] + ", ");
        }
        System.out.println(numbers[displayCount - 1] + ext);
    }

    public static void checkSorting(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i - 1] > numbers[i]) {
                System.out.println("! FEHLER: " + numbers[i - 1] + " > " + numbers[i]);
            }
        }
    }
}
