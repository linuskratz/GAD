import java.util.Random;

/**
 * Die Klasse {@link HashString} kann dazu verwendet werden,
 * Strings zu hashen.
 */
public class HashString {
  int w; 
  int [] keyArr;
  int[] hashFunc;
  int size;
  Random randomgenerator = new Random();
  

  /**
   * Dieser Konstruktor initialisiert ein {@link HashString}
   * Objekt für einen gegebenen Maximalwert (size - 1) der gehashten
   * Werte.
   * 
   * @param size die Größe der Hashtabelle; die Eingabe sollte eine Primzahl sein
   */
  public HashString (int size) {
	  w = (int)(Math.log(size)/Math.log(2)+1e-10);
	  this.size = size;
  }

  /**
   * Diese Methode berechnet den Hashwert für einen String.
   * 
   * @param key der Schlüssel, der gehasht werden sollen
   * @return der Hashwert des Schlüssels
   */
  public int hash (String key) {
	  byte [] byteArr = key.getBytes();
	  int k = byteArr.length/w;  
	  int ret = 0; 
	  keyArr = new int [k];
	  hashFunc = new int[k];
	  int keyIntervall = (int) (Math.pow(2, w)-1);
	  
	  
	  for (int j = 0; j<k; j++) {
		  int sum = 1;
		  for (int i = j*w; i<(j+1)*w; i++) {
			  sum += byteArr[i];
		  }
		  keyArr[j] = Math.floorMod(sum, keyIntervall);
		  hashFunc[j] = Math.floorMod((int)Math.pow(Math.pow(key.length(), size), (j+1)), size);
		  ret += keyArr[j] * hashFunc[j];
	  }
	  ret = ret % size;
    return ret;
  }
  
  
}
