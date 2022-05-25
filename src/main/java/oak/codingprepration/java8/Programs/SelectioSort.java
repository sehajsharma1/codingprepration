package oak.codingprepration.java8.Programs;

public class SelectioSort {

	public static void main(String[] args) {
		SelectioSort selectionSort = new SelectioSort();
		Comparable[] unsortedArray = new Comparable[] { 7, 21, 2, 3, 4, 11, 1 };
		System.out.println("Unsorted Array:");
		selectionSort.printingArray(unsortedArray);
		selectionSort.sort(unsortedArray);
		System.out.println("Sorted Array:");
		selectionSort.printingArray(unsortedArray);
	}

	public void sort(Comparable[] a) { // Sort a[] into increasing order.
		int N = a.length; // array length
		for (int i = 0; i < N; i++) { // Exchange a[i] with smallest entry in a[i+1...N).
			int min = i; // index of minimal entr.
			for (int j = i + 1; j < N; j++)
				if (less(a[j], a[min]))
					min = j;
			exch(a, i, min);
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
