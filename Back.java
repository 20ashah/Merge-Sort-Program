
/*
 This class contains an array of integers as an instance variable and 
 it contains methods to sort and search this array using merge sort
 and binary search recursively. 
*/

import java.util.*;

public class Back {

	private int[] numbers; // list of integers inputed

	// default constructor for instantiating the array of integers
	public Back() {
		numbers = new int[10];
	}

	// constructor for setting the array of integers
	public Back(ArrayList<Integer> n) {
		numbers = new int[n.size()]; // creates array
		// puts elements from list into the array
		for (int i = 0; i < n.size(); i++) {
			numbers[i] = n.get(i);
		}
	}

	// returns the list of numbers entered by user
	public int[] getSorted() {
		return numbers;
	}

	// sorting the list of numbers using merge sort
	public void sort(int left, int right) {
		// continues while left pointer < right pointer
		if (left < right) {
			int m = (left + right) / 2; // middle index

			sort(left, m); // sorts the left half
			sort(m + 1, right); // sorts the right half

			merge(left, m, right); // merges the two sorted arrays together
		}
	}

	// method for merging the arrays together into a sorted list
	public void merge(int l, int m, int r) {
		// find sizes of the sub arrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		// creating the temporary arrays
		int L[] = new int[n1];
		int R[] = new int[n2];

		// copy data to the temporary arrays
		for (int i = 0; i < n1; ++i)
			L[i] = numbers[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = numbers[m + 1 + j];

		// merge the temporary arrays
		int i = 0, j = 0; // initial indexes of first and second sub arrays
		int k = l; // initial index of merged sub array
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				numbers[k] = L[i];
				i++;
			} else {
				numbers[k] = R[j];
				j++;
			}
			k++;
		}

		// copy remaining elements of L[] if there are any
		while (i < n1) {
			numbers[k] = L[i];
			i++;
			k++;
		}

		// copy remaining elements of R[] if there are any
		while (j < n2) {
			numbers[k] = R[j];
			j++;
			k++;
		}
	}

	// recursive binary search method on the list of numbers
	public int binarySearch(int left, int right, int key) {
		int middleIndex = (left + right) / 2; // calculate middle index

		if (right < left) { // right pointer < left pointer means number isn't in array
			return -1;
		}

		if (key == numbers[middleIndex]) { // if key is in the middle index
			return middleIndex;
		} else if (key < numbers[middleIndex]) { // key is less than middle index
			return binarySearch(left, middleIndex - 1, key); // do search again on first half
		} else { // if key is greater than middle index
			return binarySearch(middleIndex + 1, right, key); // do search again on second half
		}
	}

}
