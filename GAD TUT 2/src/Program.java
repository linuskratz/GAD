
import java.awt.GraphicsEnvironment;


public class Program {
    // Wird bei Ausführung in TUMJudge automatisch auf "true" gesetzt. Falls "true" keine zusätzlich Ausgaben ausgeben!
    public final static boolean TUMJUDGE = GraphicsEnvironment.isHeadless();

    // "main"-Funktion nicht ändern!
    public static void main (String[] args) {
        if(TUMJUDGE) {
            BinSeaIO.Input input = BinSeaIO.readInput();
            Interval result = BinSea.search(input.getSortedData(), input.getValueRange());
            BinSeaIO.printOutput(result);
            return;
        }       
        
        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(80, 10000)) + "\t(Erwartetes Ergebnis: [2;4])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(100, 10000)) + "\t(Erwartetes Ergebnis: [2;4])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(0, 10000)) + "\t(Erwartetes Ergebnis: [0;4])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(-10, 10000)) + "\t(Erwartetes Ergebnis: [0;4])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(100, 10000)) + "\t(Erwartetes Ergebnis: [2;6])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(101, 10000)) + "\t(Erwartetes Ergebnis: [3;6])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(102, 10000)) + "\t(Erwartetes Ergebnis: [4;6])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(104, 10000)) + "\t(Erwartetes Ergebnis: [5;6])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(3000, 10000)) + "\t(Erwartetes Ergebnis: [6;6])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(3001, 10000)) + "\t(Erwartetes Ergebnis: [])");

        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(-100, 100)) + "\t(Erwartetes Ergebnis: [0;2])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(-100, 1)) + "\t(Erwartetes Ergebnis: [0;0])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(-100, -5)) + "\t(Erwartetes Ergebnis: [])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 127, 3000}, new NonEmptyInterval(-100, 128)) + "\t(Erwartetes Ergebnis: [0;3])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(-100, 101)) + "\t(Erwartetes Ergebnis: [0;3])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(-100, 103)) + "\t(Erwartetes Ergebnis: [0;4])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(-100, 3000)) + "\t(Erwartetes Ergebnis: [0;6])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(-100, 100)) + "\t(Erwartetes Ergebnis: [0;2])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(-100, 100)) + "\t(Erwartetes Ergebnis: [0;2])");
        System.out.println(BinSea.search(new int[] {1, 27, 100, 101, 102, 127, 3000}, new NonEmptyInterval(-100, 100)) + "\t(Erwartetes Ergebnis: [0;2])");
    }

}
