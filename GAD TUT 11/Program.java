import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Program Klasse darf nicht erweitert oder verändert werden, außer explizit
 * angegeben!
 */
public class Program {
    // Initialisierung des Testarrays, darf abgeändert werden
    public final static int SEED = 10;
    public final static int N = 100;

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
        Graph g = new Graph();
        ArrayList<Integer> tests = new ArrayList<>();

        if (TUMJUDGE) {
            Scanner scanner = new Scanner(System.in);
            Scanner lineScanner = new Scanner(scanner.nextLine());

            int n = lineScanner.nextInt(); // Zeile 1: wie viele Knoten sind vorhanden?
            for (int i = 0; i < n; i++) {
                g.addNode(); // Bereite n Knoten mit aufsteigenden Indices vor
            }

            for (int i = 0; i < n; i++) {
                // nächste n Zeilen: Kantenverbindungen...
                Graph.Node node = g.getNode(i);

                lineScanner = new Scanner(scanner.nextLine());
                while (lineScanner.hasNextInt()) {
                    Graph.Node neighbor = g.getNode(lineScanner.nextInt());
                    g.addEdge(node, neighbor);
                }
            }

            lineScanner = new Scanner(scanner.nextLine());
            while (lineScanner.hasNextInt()) {
                // Für jeden Testfall eine Zahl = Index des Knotens, dessen Tiefe später ausgegeben werden soll
                tests.add(lineScanner.nextInt());
            }

            lineScanner.close();
            scanner.close();
        } else {
            Random r = new Random(SEED);
            for (int i = 0; i < N; i++) {
                g.addNode(); // Bereite N Knoten mit aufsteigenden Indices vor
            }
            for (int i = 0; i < N; i++) {
                // nächste n Zeilen: Kantenverbindungen...
                Graph.Node node = g.getNode(i);
                int e = r.nextInt(5) + 1;
                ArrayList<Integer> edges = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    if (j != i) {
                        edges.add(j);
                    }
                }
                for (int j = 0; j < N - e; j++) {
                    edges.remove(r.nextInt(edges.size()));
                }
                for (int edge : edges) {
                    Graph.Node neighbor = g.getNode(edge);
                    g.addEdge(node, neighbor);
                }
            }
            for (int i = 0; i < N; i++) {
                tests.add(i);
            }
        }

        // Aufgabe: Führe eine Breitensuche auf dem ersten Knoten (Index 0) aus,
        // und gebe die daraus resultierende Knotentiefe der gelisteten Testknoten aus.
        // Zähle dann die Zusammenhangskomponenten, und gebe Sie in der angegebenen
        // Formatierung aus.

        BFS search = new BFS();
        search.sssp(g.getNode(0));

        for (Integer t : tests) {
            try {
                Integer depth = search.getDepth(g.getNode(t));
                System.out.print(depth + " ");
            } catch (RuntimeException e) {
                System.out.print("nc ");
            }
        }
        System.out.println();

        ConnectedComponents cc = new ConnectedComponents();
        System.out.println("Connected components: " + cc.countConnectedComponents(g));
    }
}
