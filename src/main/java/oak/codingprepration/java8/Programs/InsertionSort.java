package oak.codingprepration.java8.Programs;

public class InsertionSort {

	public static void main(String[] args) {
		InsertionSort insertionSort = new InsertionSort();
		Comparable[] unsortedArray = new Comparable[] { 7, 21, 2, 3, 4, 11, 1 };
		System.out.println("Unsorted Array:");
		insertionSort.printingArray(unsortedArray);
		insertionSort.sort(unsortedArray);
		System.out.println("Sorted Array:");
		insertionSort.printingArray(unsortedArray);
	}

	public void sort(Comparable[] a) { // Sort a[] into increasing order.
		int N = a.length;
		for (int i = 1; i < N; i++) { // Insert a[i] among a[i-1], a[i-2], a[i-3]... ..
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
				exch(a, j, j - 1);
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
