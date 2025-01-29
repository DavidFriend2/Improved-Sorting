package sorting;

/*
 * OpenDSA Project Distributed under the MIT License
 * 
 * Copyright (c) 2011-2016 - Ville Karavirta and Cliff Shaffer
 * 
 * Modifications by Nathan Sprague 2016.
 */

/**
 * Merge sort class.
 */
public class MergeSort {

  /**
   * Merge sort the provided array.
   */
  @SuppressWarnings("unchecked")
  public static <T extends Comparable<T>> void mergeSort(T[] items) {

    // Unfortunately, it is not possible to create an array of T's, this is the
    // workaround.
    T[] temp = (T[]) new Comparable[items.length];

    mergeSort(items, temp, 0, items.length - 1);
  }

  /**
   * Recursive helper method for the merge sort algorithm.
   *
   * @param items The array to sort
   * @param temp Temporary array for merge operation
   * @param left Index of the left end of the region to sort
   * @param right Index of the right end of the region to sort.
   */
  private static <T extends Comparable<T>> void mergeSort(T[] items, T[] temp, int left,
      int right) {

    if (left >= right) { // List has one record
      return;
    }

    int mid = (left + right) / 2; // Select midpoint

    mergeSort(items, temp, left, mid); // Mergesort first half
    mergeSort(items, temp, mid + 1, right); // Mergesort second half

    merge(items, temp, left, mid, right);

  }

  /**
   * Merge two sorted sub-arrays.
   */
  private static <T extends Comparable<T>> void merge(T[] items, T[] temp, int left, int mid,
      int right) {

    for (int i = left; i <= right; i++) {
      temp[i] = items[i]; // Copy subarray to temp
    }

    int i1 = left;
    int i2 = mid + 1;
    for (int curr = left; curr <= right; curr++) {
      if (i1 == mid + 1) { // Left subarray exhausted
        items[curr] = temp[i2++];
      } else if (i2 > right) { // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(temp[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = temp[i2++];
      }
    }
  }


}
