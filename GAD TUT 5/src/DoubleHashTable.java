import java.util.*;

/**
 * Die Klasse DoubleHashTable implementiert eine Hashtabelle, die doppeltes
 * Hashing verwendet.
 *
 * @param <K> der Typ der Schlüssel, die in der Hashtabelle gespeichert werden
 * @param <V> der Typ der Werte, die in der Hashtabelle gespeichert werden
 */
public class DoubleHashTable<K, V> {
	DoubleHashable<K> hf;
	int size; 
	@SuppressWarnings("unchecked")
	Pair <K,V> table [];
	int collissions;
	int rehashes;
	int numberOfElements;
	int hash;
	
  /**
   * Diese Methode implementiert h(x, i).
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @param i der Index, der angibt, der wievielte Hash für den gegebenen Schlüssel
   * berechnet werden soll
   * @return der generierte Hash
   */
  private int hash(K key, int i) {
	return Math.floorMod((hf.hash(key) + i*hf.hashTick(key)), size);
  }

  /**
   * Dieser Konstruktor initialisiert die Hashtabelle.
   * 
   * @param primeSize die Größe 'm' der Hashtabelle; es kann davon ausgegangen
   * werden, dass es sich um eine Primzahl handelt.
   * @param hashableFactory Fabrik, die aus einer Größe ein DoubleHashable<K>-Objekt erzeugt.
   */
  @SuppressWarnings("unchecked")
public DoubleHashTable(int primeSize, HashableFactory<K> hashableFactory) {
	  this.size = primeSize;
	  this.hf = hashableFactory.create(primeSize);
	  this.collissions = 0;
	  this.rehashes = 0;
	  this.table = new Pair [size];
	  this.numberOfElements = 0;
  }

  /**
   * Diese Methode fügt entsprechend des doppelten Hashens ein Element
   * in die Hashtabelle ein.
   * 
   * @param k der Schlüssel des Elements, das eingefügt wird
   * @param v der Wert des Elements, das eingefügt wird
   * @return 'true' falls das einfügen erfolgreich war, 'false' falls die
   * Hashtabelle voll ist.
   */
  public boolean insert(K k, V v) { 
	Pair<K,V> insert = new Pair <>(k, v);
	
	int collisions = 0; 
    while (table[hash(k, collisions)]!= null && !table[hash(k, collisions)]._1.equals(k)) { 
    	collisions ++;
    	if (collisions == table.length)
    		return false;
    }
    if (table[hash(k, collisions)]== null) {
    	numberOfElements++;
    }
    
    table [hash(k, collisions)] = insert;
    
    if (collisions > 1)
    	this.collissions += 1;
    
    this.rehashes = Math.max(rehashes, collisions);
    return true;
  }

  /**
   * Diese Methode sucht ein Element anhand seines Schlüssels in der Hashtabelle
   * und gibt den zugehörigen Wert zurück, falls der Schlüssel gefunden wurde.
   * 
   * @param k der Schlüssel des Elements, nach dem gesucht wird
   * @return der Wert des zugehörigen Elements, sofern es gefunden wurde
   */
 public Optional<V> find(K k) {
	 for (int i= 0; i<=maxRehashes(); i++) {
		 if (table[hash(k, i)] != null && table[hash(k, i)]._1.equals(k))
			 return (Optional<V>) Optional.of(table[hash(k, i)]._2);
	 }
	 return Optional.empty();
  }

  /**
   * Diese Methode ermittelt die Anzahl der Kollisionen, also die Anzahl
   * der Elemente, die nicht an der 'optimalen' Position in die Hashtabelle eingefügt
   * werden konnten. Die optimale Position ist diejenige Position, die der
   * erste Aufruf der Hashfunktion (i = 0) bestimmt.
   * 
   * @return die Anzahl der Kollisionen
   */
  public int collisions() {
    return collissions;
  }
 
  /**
   * Diese Methode berechnet die maximale Anzahl von Aufrufen der Hashfunktion,
   * die nötig waren, um ein einziges Element in die Hashtabelle einzufügen.
   * 
   * @return die berechnete Maximalzahl von Aufrufen
   */
  public int maxRehashes() {
    return rehashes;
  }
}
