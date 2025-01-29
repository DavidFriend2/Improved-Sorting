package sorting;

/**
 * Improved MergeSort class.
 */

public class MergeSortImproved {
  
  private static final int MERGE_SORT_THRESHOLD = 115;
  
  /**
   * Merge sort the provided array using an improved merge operation.
   */
  public static <T extends Comparable<T>> void mergeSortHalfSpace(T[] items) {
    T[] temp = (T[]) new Comparable[(items.length + 1) / 2];

    mergeSortHalfSpace(items, temp, 0, items.length - 1);
  }
  
  private static <T extends Comparable<T>> void mergeSortHalfSpace(T[] items, T[] temp, 
      int left, int right) {
    if (left >= right) { // List has one record
      return;
    }
    
    int mid = (left + right) / 2; // Select midpoint

    mergeSortHalfSpace(items, temp, left, mid);
    mergeSortHalfSpace(items, temp, mid + 1, right);
    
    merge(items, temp, left, mid, right);
  }
  
  private static <T extends Comparable<T>> void merge(T[] items, T[] temp, int left, int mid,
      int right) {
    int count = 0;
    for (int i = left; i <= mid; i++) {
      temp[count] = items[i];
      count++;
    }
    int i1 = 0;
    int i2 = mid + 1;
    for (int curr = left; curr <= right; curr++) {
      if (i1 == mid + 1 - left) { // Left subarray exhausted
        items[curr] = items[i2++];
      } else if (i2 > right) { // Right subarray exhausted
        items[curr] = temp[i1++];
      } else if (temp[i1].compareTo(items[i2]) <= 0) { // Get smaller value
        items[curr] = temp[i1++];
      } else {
        items[curr] = items[i2++];
      }
    }
  }


  /**
   * Merge sort the provided array by using an improved merge operation and
   * switching to insertion sort for small sub-arrays.
   */
  public static <T extends Comparable<T>> void mergeSortAdaptive(T[] items) {
    if (items.length < MERGE_SORT_THRESHOLD) {
      BasicSorts.insertionSort(items);
    } else {
      mergeSortHalfSpace(items);
    }
    
  }

  /**
   * Merge sort the provided sub-array using our improved merge sort. This is the
   * fallback method used by introspective sort.
   */
  public static <T extends Comparable<T>> void mergeSubsortAdaptive(T[] items, int start, int end) {
    if (end - start < MERGE_SORT_THRESHOLD) {
      BasicSorts.insertionSubsort(items, start, end);
    } else {
      T[] temp = (T[]) new Comparable[((end + 1 - start) + 1) / 2];
      mergeSortHalfSpace(items, temp, start, end);
    }
  }
}
