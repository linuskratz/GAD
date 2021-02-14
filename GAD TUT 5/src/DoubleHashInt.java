import java.util.Random;

/**
 * Die Klasse {@link DoubleHashInt} kann dazu verwendet werden, Integer zu
 * hashen.
 */
public class DoubleHashInt implements DoubleHashable<Integer> {
	int maxsize;
	int w;
	int [] hashFunc;
	int keyInterval;

	/**
	 * Dieser Konstruktor initialisiert ein {@link DoubleHashInt} Objekt für einen
	 * gegebenen Maximalwert (size - 1) der gehashten Werte.
	 * 
	 * @param size die Größe der Hashtabelle
	 */
	public DoubleHashInt(int size) {
		maxsize = size;
		w = 16;
		Random rand = new Random();
		hashFunc = new int [] {rand.nextInt(size-1), rand.nextInt(size-1)};
		keyInterval = (int) Math.pow(2, w-1);
	}

	/**
	 * Diese Methode berechnet h(key) für einen Integer.
	 * 
	 * @param key der Schlüssel, der gehasht werden soll
	 * @return der Hashwert des Schlüssels
	 */
	@Override
	public long hash(Integer key) {
		int ret=1; 
		for (int i = 0; i<2; i++) {
			ret += Math.floorMod(key, keyInterval) * hashFunc[i];
		}
		return  Math.floorMod(2*ret+1,maxsize);
	}
	/**
	 * Diese Methode berechnet h'(key) für einen Integer.
	 * 
	 * @param key der Schlüssel, der gehasht werden soll
	 * @return der Hashwert des Schlüssels
	 */
	@Override
	public long hashTick(Integer key) {
		int ret=1; 
		for (int i = 0; i<2; i++) {
			ret += Math.floorMod(key, keyInterval) * hashFunc[i];
		}
		return  Math.floorMod(ret,maxsize-1)+1;
	}

}
