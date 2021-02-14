public class Quicksort extends SortingBase {

    @Override
    public void sort(int[] numbers) {
        sort(numbers, 0, numbers.length - 1);
    }

    @Override
    public String getName() {
        return "Quicksort";
    }

    protected void sort(int[] numbers, int l, int r) {
    	if (l< r) {
    		int p = numbers [r];
    		int i = l-1;
    		int j =r;
    		do {
    			do {i++;} while (numbers[i]<p);
    			do {j--;} while (j>=l && numbers[j]>p);
    			if (i<j) {swap(numbers, i,j);}
    		}while(i<j);
    		swap(numbers, i,r);
    	
        
        if (verbose) {
            Program.printArray("", numbers);
        }

        sort(numbers, l, i-1);
        sort(numbers, i+1, r);
        
    	}
    }
    
    private void swap (int[] numbers, int pos1, int pos2) {
    	int temp = numbers[pos1];
    	numbers [pos1] = numbers [pos2];
    	numbers [pos2] = temp;
    }
}
