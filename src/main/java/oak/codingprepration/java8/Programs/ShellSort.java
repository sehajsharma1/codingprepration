package oak.codingprepration.java8.Programs;

public class ShellSort {

	public static void main(String[] args) {
		ShellSort shellSort = new ShellSort();
		Comparable[] unsortedArray = new Comparable[] { 7, 21, 2, 3, 4, 11, 1 };
		System.out.println("Unsorted Array:");
		shellSort.printingArray(unsortedArray);
		shellSort.sort(unsortedArray);
		System.out.println("Sorted Array:");
		shellSort.printingArray(unsortedArray);
	}

	public void sort(Comparable[] a) { // Sort a[] into increasing order.
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1) { // h-sort the array.
			for (int i = h; i < N; i++) { // Insert a[i] among a[i-h], a[i-2*h], a[i-3*h]... .
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h)
					exch(a, j, j - h);
			}
			h = h / 3;
		}
	}

	public boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;

	}

	private void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public void printingArray(Comparable[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}

}
