
/**
 * Die Klasse BinSea stellt Methoden bereit, in sortierten Feldern binär nach
 * Wertebereichen zu suchen.
 */
class BinSea {
	/**
	 * Diese Methode sucht nach einem Wert in einem einem sortierten Feld. Sie soll
	 * dabei dazu verwendet werden können, den ersten bzw. letzten Index in einem
	 * Intervall zu finden. Wird kein passender Index gefunden, wird -1
	 * zurückgegeben.
	 * 
	 * Beispiel:
	 * 
	 * 0 <-----------------------> 5 sortedData: [-10, 33, 50, 99, 123, 4242 ]
	 * value: 80 ^ ^ | | | `- Ergebnis (3) für ersten Index im Intervall (lower ==
	 * true), | da 99 als erster Wert im Feld größer oder gleich 80 ist | `-
	 * Ergebnis (2) für letzten Index im Intervall (lower == false), da 50 als
	 * letzter Wert kleiner oder gleich 80 ist
	 * 
	 * @param sortedData das sortierte Feld, in dem gesucht wird
	 * @param value      der Wert der Intervallbegrenzung, nach dem gesucht wird
	 * @param lower      true für untere Intervallbegrenzung, false für obere
	 *                   Intervallbegrenzung
	 * @return der passende Index, -1 wenn dieser nicht gefunden werden kann
	 */
	private static int search(int[] sortedData, int value, boolean lower) {
		if (sortedData.length == 0 || sortedData == null) {
			return -1;
		}
		return searchRec(sortedData, value, 0, sortedData.length - 1, lower);
	}

	private static int searchRec(int[] sortedData, int value, int lowerbound, int upperbound, boolean lower) {
		int midIndex = (upperbound + lowerbound) / 2;

		if (lowerbound + 1 == upperbound || upperbound == lowerbound) {
			if (sortedData[lowerbound] <= value && lower) {
				if (sortedData[upperbound] <= value) {
					return upperbound;
				} else {
					return lowerbound;
				}
			} else if (sortedData[upperbound] >= value && !lower) {
				if (sortedData[lowerbound] >= value) {
					return lowerbound;
				} else {
					return upperbound;
				}
			} else
				return -1;
		}
		if (sortedData[midIndex] == value && lower || sortedData[midIndex] > value) {
			return searchRec(sortedData, value, lowerbound, midIndex, lower);
		}
		return searchRec(sortedData, value, midIndex, upperbound, lower);
	}

	/**
	 * Diese Methode sucht ein Intervall von Indices eines sortierten Feldes, deren
	 * Werte in einem Wertebereich liegen. Es soll dabei binäre Suche verwendet
	 * werden.
	 * 
	 * Beispiel: 0 <-----------------------> 5 sortedData: [-10, 33, 50, 99, 123,
	 * 4242 ] valueRange: [80;700] ^ ^ | | | `- Ergebnis (4) für obere
	 * Intervallbegrenzung, | da 123 als letzter Wert kleiner oder gleich 700 ist |
	 * `- Ergebnis (3) für untere Intervallbegrenzung, da 99 als erster Wert größer
	 * oder gleich 80 ist
	 * 
	 * @param sortedData das sortierte Feld, in dem gesucht wird
	 * @param valueRange der Wertebereich, zu dem Indices gesucht werden
	 */
	public static Interval search(int[] sortedData, Interval valueRange) {
		if (sortedData.length == 0 || sortedData == null)
			return new EmptyInterval();
		int upperInterval = searchRec(sortedData, valueRange.getTo(), 0, sortedData.length - 1, true);

		if (upperInterval == -1) {
			return new EmptyInterval();
		}
		int lowerInterval = searchRec(sortedData, valueRange.getFrom(), 0, upperInterval, false);
		if (lowerInterval == -1) {
			return new EmptyInterval();
		} else {
			return new NonEmptyInterval(lowerInterval, upperInterval);
		}
	}
}
