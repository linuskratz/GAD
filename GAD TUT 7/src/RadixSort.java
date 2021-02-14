import java.util.ArrayList;
public class RadixSort {
    private static int key(Integer element, int decimalPlace) throws IllegalArgumentException {
    	if (element < 0)
    		throw new IllegalArgumentException();
    	for (int i = 0; i<decimalPlace; i++)
    		element = element/10;
        return element%10;
    }

    private static void concatenate(ArrayList<Integer>[] buckets, Integer[] elements) {
    	ArrayList<Integer> ret = new ArrayList<>();
    	for (ArrayList<Integer> i:buckets)
    		ret.addAll(i);
    	System.arraycopy(ret.toArray(), 0, elements, 0, elements.length);
    }

    private static void kSort(Integer[] elements, int decimalPlace) {
        ArrayList<Integer>[] ret = new ArrayList[10];
        for (int i=0; i<=9; i++) {
        	ret[i] = new ArrayList<Integer>();
        }
        for (int i:elements) {
        	ret[key(i, decimalPlace)].add(i);
        }
        concatenate(ret, elements);
    }
    
    private static int getMaxDecimalPlaces(Integer[] elements) {
    	int maxDecimalPlaces = 0;
    	for (int i :elements) {
    		while ((i / Math.pow(10, maxDecimalPlaces))>= 1)
    			maxDecimalPlaces ++;
    	}
		return maxDecimalPlaces;
    }

    public static void sort(Integer[] elements, boolean verbose) {
    	int maxDecimal = getMaxDecimalPlaces(elements);
    	for (int i = 0; i<maxDecimal; i++) {
    		kSort(elements, i);
    		if (verbose)
    			Program.printArray(elements);
    	}
    }
}
