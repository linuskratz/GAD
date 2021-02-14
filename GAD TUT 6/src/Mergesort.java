public class Mergesort extends SortingBase {

	@Override
	public void sort(int[] numbers) {
		sort(numbers, 0, numbers.length - 1);
	}

	@Override
	public String getName() {
		return "Mergesort";
	}

	protected void sort(int[] numbers, int l, int r) {
		if (l == r)
			return;
		int m = (r + l) / 2;
		sort(numbers, l, m);
		sort(numbers, m + 1, r);

		int j = l;
		int k = m + 1;
		int[] b = new int[(r - l)+1];

		for (int i = 0; i <= r - l; i++) {
			if (j > m) {
				b[i] = numbers[k];
				k++;
			} else {
				if (k > r) {
					b[i] = numbers[j];
					j++;
				} else {
					if (numbers[j] <= numbers[k]) {
						b[i] = numbers[j];
						j++;
					} else {
						b[i] = numbers[k];
						k++;
					}
				}
			}
		}
		for (int i = 0; i <= r - l; i++) {
			numbers[l+i]=b[i];
		}

		if (verbose)

		{
			Program.printArray("", numbers);
		}
	}
}
