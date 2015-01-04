import java.util.*;
import java.io.*;

public class MergeSort {

	public static void main(String[] args) {
		Integer[] myList = {5, 2, 5, 4, 3, 6, 8, 1}, sortedList;

		sortedList = mergeSort(myList);

		System.out.println("Sorted list:");
		System.out.print(Arrays.toString(sortedList));
		System.out.println();
	}

	static Integer[] mergeSort(Integer[] list) {
		Integer[] left, right, merged, temp1, temp2;
		int sizeLeft, sizeRight;

		if (list.length == 1)
			return list;
		else {
			sizeLeft = list.length / 2;
			sizeRight = list.length - sizeLeft;
			temp1 = new Integer[sizeLeft];
			temp2 = new Integer[sizeRight];
			System.arraycopy(list, 0, temp1, 0, sizeLeft);
			System.arraycopy(list, sizeLeft, temp2, 0, sizeRight);

			left = mergeSort(temp1);
			right = mergeSort(temp2);
			merged = merge(left, right);
		}
		return merged;
	}

	static Integer[] merge(Integer[] left, Integer[] right) {
		Integer[] merged = new Integer[left.length + right.length];
		int i, j, k;

		for (i = 0, j = 0, k = 0; i < left.length && j < right.length; k++) {
			if (left[i] < right[j]) {
				merged[k] = left[i];
				i++;
			}
			else {
				merged[k] = right[j];
				j++;
			}
		}
		while (i < left.length)
			merged[k++] = left[i++];
		while (j < right.length)
			merged[k++] = right[j++];

		return merged;
	}
}