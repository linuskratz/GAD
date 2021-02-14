import java.util.ArrayList;
import java.util.Random;

/**
 * Die Klasse {@link DoubleHashString} kann dazu verwendet werden,
 * Strings zu hashen.
 */
public class DoubleHashString implements DoubleHashable<String> {
  int maxsize; 
  int w; 
  ArrayList<Integer> keys = new ArrayList<Integer>();
  int keyInterval;
  Random rand;

  /**
   * Dieser Konstruktor initialisiert ein {@link DoubleHashString}
   * Objekt für einen gegebenen Maximalwert (size - 1) der gehashten
   * Werte.
   * 
   * @param size die Größe der Hashtabelle
   */
  public DoubleHashString (int size) {
	  rand = new Random();
	  w = 16;
	  maxsize = size;
	  keyInterval = (int) Math.pow(2, w-1);
  }
  
  /**
   * Diese Methode berechnet h(key) für einen String.
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @return der Hashwert des Schlüssels
   */
  public long hash (String key) {
	  int k = (key.length()/w) +1; 
	  int ret = 1;
	  
	  while (k > keys.size()) {
		  keys.add(rand.nextInt(maxsize-1));
	  }
	  for (int i= 0; i<k; i++) {
		  int sum =1;
		  for (int j =i*k; j<(i+1)*w && j<key.length(); j++) {
			  sum += key.charAt(j);
		  }
		  ret += Math.floorMod(sum, keyInterval) * keys.get(i);
	  }
	  
	  return Math.floorMod(3*ret+1, maxsize);  
  }
  
  /**
   * Diese Methode berechnet h'(key) für einen String.
   * 
   * @param key der Schlüssel, der gehasht werden soll
   * @return der Hashwert des Schlüssels
   */
  public long hashTick (String key) {
	  int k = (key.length()/w) +1; 
	  int ret = 1;
	  
	  while (k > keys.size()) {
		  keys.add(rand.nextInt(maxsize-1));
	  }
	  for (int i= 0; i<k; i++) {
		  int sum =1;
		  for (int j =i*k; j<(i+1)*w && j<key.length(); j++) {
			  sum += key.charAt(j);
		  }
		  ret += Math.floorMod(sum, keyInterval) * keys.get(i);
	  }
	  return Math.floorMod(ret, maxsize-1)+1;  
  }
}
